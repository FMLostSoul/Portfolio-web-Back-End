package com.yoprogramo.portfolioweb.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserProfile {

    @Id
    private int id = 1; //Solo existe un usuario, por ahora
    private String userName;
    private String careerInfo;
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_profile_URLS", joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "url_id"))
    private List<Url> urls;
}
