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
public class School {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String teacher;
}
