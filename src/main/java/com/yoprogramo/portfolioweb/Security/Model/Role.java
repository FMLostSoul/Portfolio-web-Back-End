package com.yoprogramo.portfolioweb.Security.Model;

import com.yoprogramo.portfolioweb.Security.Enum.RoleName;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }
    
    

   

    
}
