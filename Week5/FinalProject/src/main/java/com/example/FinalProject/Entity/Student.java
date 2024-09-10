package com.example.FinalProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Year;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column
    private int id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private int age;
    @Column
    private int start_year;
    @Column
    private Teacher teacher;
    @Column
    private String belt;

}
