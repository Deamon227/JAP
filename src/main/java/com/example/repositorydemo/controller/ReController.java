package com.example.repositorydemo.controller;

import com.example.repositorydemo.model.Student;
import com.example.repositorydemo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/student")
public class ReController {
    @Autowired
    private IStudentService studentService;
    @GetMapping()
    public ModelAndView index(){
        ModelAndView m = new ModelAndView("index","students", studentService.findAll());
        return m;
    }

    @GetMapping("/add")
    public ModelAndView showAdd(){
        ModelAndView m = new ModelAndView("add", "student", new Student());
        return m;
    }

    @PostMapping("/add")
    public String add(Student student){
        studentService.saveWithStoredProcedure(student);
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        ModelAndView m = new ModelAndView("update", "student", studentService.findById(id));
        return m;
    }

    @PostMapping("/edit/{id}")
    public String edit(Student student, @PathVariable Long id){
        student.setId(id)   ;
        studentService.saveWithStoredProcedure(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        studentService.remove(id);
        return "redirect:/student";
    }
}
