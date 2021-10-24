package com.example.battleships.model.view;

import com.example.battleships.model.entity.User;

import java.math.BigInteger;

public class ShipViewModel {
    private Long id;
    private String name;
    private User user;
    private Integer health;
    private Integer power;

    public ShipViewModel() {
    }

    public Integer getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipViewModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipViewModel setUser(User user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
