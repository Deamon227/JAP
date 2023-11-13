package com.example.repositorydemo.service.student;

import com.example.repositorydemo.model.Student;
import com.example.repositorydemo.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
       iStudentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.remove(id);
    }

    @Override
    public boolean saveWithStoredProcedure(Student student) {
        return iStudentRepository.saveWithStoredProcedure(student);
    }
}
