package com.example.bookclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDTO {

    private String name;

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
