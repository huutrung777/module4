package com.example.module4.controller;

import com.example.module4.entity.Student;
import com.example.module4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    //    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }
    @GetMapping("/students")
    public String showList(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student/list";

    }
}
