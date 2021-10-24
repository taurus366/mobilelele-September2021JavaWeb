package com.example.battleships.model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false,columnDefinition = "bigint")
    private Integer health;

    @Column(nullable = false,columnDefinition = "bigint")
    private Integer power;

    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public Ship setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public Ship setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Ship setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }



    @PrePersist
    public  void beforeCreate() {
        this.created = new Date();
    }
}
