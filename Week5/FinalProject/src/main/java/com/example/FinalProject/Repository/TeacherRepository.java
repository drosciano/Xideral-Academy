package com.example.FinalProject.Repository;

import com.example.FinalProject.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<School, Integer> {
}
