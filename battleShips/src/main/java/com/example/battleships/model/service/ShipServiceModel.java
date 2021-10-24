package com.example.battleships.model.service;

import com.example.battleships.model.entity.CategoryEnum;
import com.example.battleships.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

public class ShipServiceModel {

    private String name;
    private BigInteger power;
    private BigInteger health;
    private Date created;
    private CategoryEnum category;
    private User user;

    public ShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigInteger getPower() {
        return power;
    }

    public ShipServiceModel setPower(BigInteger power) {
        this.power = power;
        return this;
    }

    public BigInteger getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(BigInteger health) {
        this.health = health;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(Date created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipServiceModel setUser(User user) {
        this.user = user;
        return this;
    }
}
