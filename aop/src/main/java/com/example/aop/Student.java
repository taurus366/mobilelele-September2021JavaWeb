package com.example.aop;

import com.example.aop.basic.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {

    public void sayHello() {
        System.out.println("HELLO!");
    }

    public void echo(String echo) {
        System.out.println("ECHO: "+ echo);
    }

    public String concat(String a, String b) {
        return a + b;
    }

    public void  boom() {
        throw new IllegalStateException("DON't CALL ME !!! DO NOT!!!!");
    }

    public List<Author> test(String ali) {


        return List.of(new Author(1L,"ali",27L),new Author(3L,"ali",24L),new Author(2L,"ali",25L));
//        return "testALI";
    }
}
