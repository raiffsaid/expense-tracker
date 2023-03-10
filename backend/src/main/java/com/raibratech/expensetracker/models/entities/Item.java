package com.raibratech.expensetracker.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "items")
public class Item {
    @Id
    private String id;
    private LocalDate date;
    private String category;
    private String title;
    private Double value;
    private String userId;

    public Item() {}

    public Item(String id, LocalDate date, String category, String title, Double value, String userId) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.title = title;
        this.value = value;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
