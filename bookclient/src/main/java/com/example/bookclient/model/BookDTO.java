package com.example.bookclient.model;

public class BookDTO {

    private AuthorDTO authorDTO;

    private Long id;
    private String title;
    private String isbn;

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public BookDTO setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BookDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "authorDTO=" + authorDTO +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
