package com.cave.springbootdemo.example1.person;

import com.cave.springbootdemo.example1.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class PersonController {

    @RequestMapping("/")
    public void controller(){
        System.out.println("Controller");
        service.service();
        studentService.service();
    }

    @Autowired
    private PersonService service;

    @Autowired
    private StudentService studentService;

}
