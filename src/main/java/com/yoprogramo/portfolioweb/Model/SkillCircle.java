package com.yoprogramo.portfolioweb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class SkillCircle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int percent;
    private String skill;
}
