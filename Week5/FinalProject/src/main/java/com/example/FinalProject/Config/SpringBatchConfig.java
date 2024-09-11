package com.example.FinalProject.Config;

import com.example.FinalProject.Entity.Student;
import com.example.FinalProject.Entity.School;
import com.example.FinalProject.Repository.StudentRepository;
import com.example.FinalProject.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class SpringBatchConfig {
    private StudentRepository studentRepo;
    private TeacherRepository teacherRepo;

    @Bean
    public FlatFileItemReader<School> teacherReader() {
        FlatFileItemReader<School> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(Path_of_the_desired_file));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(teacherLineMapper());
        return itemReader;
    }

    private LineMapper<School> teacherLineMapper() {
        DefaultLineMapper<School> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(Column_names);

        BeanWrapperFieldSetMapper<School> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(School.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public FlatFileItemReader<Student> studentReader() {
        FlatFileItemReader<Student> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(Path_of_the_desired_file));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(studentLineMapper());
        return itemReader;
    }

    private LineMapper<Student> studentLineMapper() {
        DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(Column_names);

        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public TeacherProcessor teacherProcessor() {
        return new TeacherProcessor();
    }

    @Bean
    public StudentProcessor studentProcessor() {
        return new StudentProcessor();
    }

    @Bean
    public RepositoryItemWriter<School> teacherWriter() {
        RepositoryItemWriter<School> writer = new RepositoryItemWriter<>();
        writer.setRepository(teacherRepo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public RepositoryItemWriter<Student> studentWriter() {
        RepositoryItemWriter<Student> writer = new RepositoryItemWriter<>();
        writer.setRepository(studentRepo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step stepTeacher(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("csv-teacher-step", jobRepository)
                .<School, School>chunk(10, transactionManager)
                .reader(teacherReader())
                .processor(teacherProcessor())
                .writer(teacherWriter())
                .build();
    }

    @Bean
    public Step stepStudent(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("csv-student-step", jobRepository)
                .<Student, Student>chunk(10, transactionManager)
                .reader(studentReader())
                .processor(studentProcessor())
                .writer(studentWriter())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("importStudents", jobRepository)
                .start(stepTeacher(jobRepository,transactionManager))
                .next(stepStudent(jobRepository,transactionManager))
                .build();
    }


    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
