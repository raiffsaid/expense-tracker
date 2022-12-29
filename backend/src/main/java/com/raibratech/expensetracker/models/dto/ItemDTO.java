package com.raibratech.expensetracker.models.dto;

import com.raibratech.expensetracker.models.embedded.Author;
import com.raibratech.expensetracker.models.entities.Item;

import java.time.LocalDate;

public class ItemDTO {
    private String id;
    private LocalDate date;
    private String category;
    private String title;
    private Double value;
    private Author author;

    public ItemDTO() {}

    public ItemDTO(String id, LocalDate date, String category, String title, Double value, Author author) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.title = title;
        this.value = value;
        this.author = author;
    }

    public ItemDTO(Item entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.value = entity.getValue();
        this.author = entity.getAuthor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
