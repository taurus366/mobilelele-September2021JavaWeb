package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;

    public Role() {
    }

    public RoleNameEnum getName() {
        return role;
    }

    public Role setName(RoleNameEnum role) {
        this.role = role;
        return this;
    }
}
