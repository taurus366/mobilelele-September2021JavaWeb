package com.example.aop.basic;

public class Author {

    private Long id;
    private String name;
    private Long age;

    public Author() {
    }

    public Author(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public Author setAge(Long age) {
        this.age = age;
        return this;
    }
}
