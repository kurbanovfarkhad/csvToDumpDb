package com.example.mapstructexample.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PersonEntity extends BaseEntity {
    @Id
    private String id;
    private String surname;
    private String test;
    @OneToOne(targetEntity = ColourEntity.class)
    private ColourEntity favoriteColour;
    @OneToMany(targetEntity = PetEntity.class)
    private List<PetEntity> pets;

    public String getId() {
        return id;
    }

    public PersonEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getTest() {
        return test;
    }

    public PersonEntity setTest(String test) {
        this.test = test;
        return this;
    }

    public ColourEntity getFavoriteColour() {
        return favoriteColour;
    }

    public PersonEntity setFavoriteColour(ColourEntity favoriteColour) {
        this.favoriteColour = favoriteColour;
        return this;
    }

    public List<PetEntity> getPets() {
        return pets;
    }

    public PersonEntity setPets(List<PetEntity> pets) {
        this.pets = pets;
        return this;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", test='" + test + '\'' +
                ", favoriteColour=" + favoriteColour +
                ", pets=" + pets +
                '}';
    }
}
