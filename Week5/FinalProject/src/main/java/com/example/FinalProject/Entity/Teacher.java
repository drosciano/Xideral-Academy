package com.example.FinalProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
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
    private String belt;
}
