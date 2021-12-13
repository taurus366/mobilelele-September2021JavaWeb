package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Cacheable("students")
    public List<Student> findAllStudents() {
        //Do smth very time intensive here, e.g. connect to remote service
        // to download the students.

        logger.info("I'm doing some complicated stuff...");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
;           Thread.interrupted();
        }
        logger.info("Complicated calculation finished...");

        return List.of(
                new Student(1L,"Pesho",34),
                new Student(2L,"Anna",24)
        );

    }

    @CacheEvict(cacheNames="students", allEntries=true)
    public void loadStudents() {
        //...
    }
}
