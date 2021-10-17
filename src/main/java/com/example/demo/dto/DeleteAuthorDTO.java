package com.example.demo.dto;

public class DeleteAuthorDTO {
    private String author_name;

    @Override
    public String toString() {
        return "deleteAuthorDTO{" +
                "author_name='" + author_name + '\'' +
                '}';
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
