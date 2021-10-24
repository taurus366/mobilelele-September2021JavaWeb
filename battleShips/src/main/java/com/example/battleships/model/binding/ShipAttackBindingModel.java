package com.example.battleships.model.binding;

import javax.validation.constraints.NotNull;

public class ShipAttackBindingModel {
    @NotNull
    private Long attacker;
    @NotNull
    private Long defender;

    public ShipAttackBindingModel() {
    }

    public Long getAttacker() {
        return attacker;
    }

    public ShipAttackBindingModel setAttacker(Long attacker) {
        this.attacker = attacker;
        return this;
    }

    public Long getDefender() {
        return defender;
    }

    public ShipAttackBindingModel setDefender(Long defender) {
        this.defender = defender;
        return this;
    }
}
