package com.example.repositorydemo.repository.student;

import com.example.repositorydemo.model.Student;
import com.example.repositorydemo.repository.IGenerateRepository;

public interface IStudentRepository extends IGenerateRepository<Student> {
    boolean saveWithStoredProcedure(Student student);
}
