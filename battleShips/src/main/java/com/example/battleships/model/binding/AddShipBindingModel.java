package com.example.battleships.model.binding;

import com.example.battleships.model.entity.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

public class AddShipBindingModel {

    @NotNull
    @Size(min = 2,max = 10)
    private String name;

    @NotNull
    @Positive
    private Integer power;

    @NotNull
    @Positive
    private Integer health;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created;

    @NotNull
    private CategoryEnum category;

    public AddShipBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddShipBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public AddShipBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public AddShipBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public AddShipBindingModel setCreated(Date created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public AddShipBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
