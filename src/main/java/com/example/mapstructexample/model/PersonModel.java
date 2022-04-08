package com.example.mapstructexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"person_id","person_name","person_favoriteColour"})
public class PersonModel extends BaseModel {
    @JsonProperty("person_id")
    private Long id;
    @JsonProperty("person_name")
    private String name;
    @JsonProperty("person_favoriteColour")
    private String favoriteColour;
    @JsonProperty("person_pets")
    private String pets;

    public Long getId() {
        return id;
    }

    public PersonModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getFavoriteColour() {
        return favoriteColour;
    }

    public PersonModel setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour;
        return this;
    }

    public String getPets() {
        return pets;
    }

    public PersonModel setPets(String pets) {
        this.pets = pets;
        return this;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", favoriteColour=" + favoriteColour +
                ", pets=" + pets +
                '}';
    }
}
