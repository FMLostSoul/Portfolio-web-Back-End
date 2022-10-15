package com.yoprogramo.portfolioweb.Security.Model;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
public class UserCredentials {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String password;

    @NotNull
    private String name;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_credentials_rol", joinColumns = @JoinColumn(name = "user_credentials_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();
    public UserCredentials(){
        
    }
    
    public UserCredentials(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
    }
    
}
