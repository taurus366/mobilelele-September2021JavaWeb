package com.example.aop.modifying;

import com.example.aop.Student;
import com.example.aop.basic.BasicExampleAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingExample implements CommandLineRunner {

    private final Student student;
    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyingExample.class);

    public ModifyingExample(Student student) {
        this.student = student;
    }

    @Override
    public void run(String... args) throws Exception {
       String result = student.concat("A","B");

       // if there is no aspect we would expect - AB
       // if there is  aspect we would expect - ([A]-[B])

        LOGGER.info("The result from the around advice is : {}", result);
    }
}
