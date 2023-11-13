package com.example.repositorydemo.service.student;

import com.example.repositorydemo.model.Student;
import com.example.repositorydemo.service.IGenerateService;

public interface IStudentService extends IGenerateService<Student> {
    boolean saveWithStoredProcedure (Student student);
}
