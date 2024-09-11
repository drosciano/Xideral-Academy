package com.example.FinalProject.Config;

import com.example.FinalProject.Entity.School;
import org.springframework.batch.item.ItemProcessor;

public class TeacherProcessor implements ItemProcessor<School, School> {
    @Override
    public School process(School item) throws Exception {
        return item;
    }
}
