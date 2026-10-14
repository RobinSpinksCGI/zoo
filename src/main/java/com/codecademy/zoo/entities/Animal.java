package com.codecademy.zoo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ANIMALS")
//@NamedQuery(name = "findByFullSearch", query = "SELECT a FROM Animal a WHERE name = ?1 AND numLegs >= ?2 AND canFly = ?3")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NUM_LEGS")
    private Integer numLegs;
    @Column(name = "HAS_WINGS")
    private Boolean hasWings;
    @Column(name = "CAN_FLY")
    private Boolean canFly;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(Integer numLegs) {
        this.numLegs = numLegs;
    }

    public Boolean getHasWings() {
        return hasWings;
    }

    public void setHasWings(Boolean hasWings) {
        this.hasWings = hasWings;
    }

    public Boolean getCanFly() {
        return canFly;
    }

    public void setCanFly(Boolean canFly) {
        this.canFly = canFly;
    }
}