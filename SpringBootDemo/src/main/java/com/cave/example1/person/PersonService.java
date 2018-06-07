package com.cave.example1.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public void service(){
        System.out.println("Service");
        repository.repository();
    }

    @Autowired
    private PersonRepository repository;

}
