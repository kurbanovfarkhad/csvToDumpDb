package com.example.mapstructexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonForm extends BaseForm {
    @JsonProperty(value = "person_id")
    private String id;
    @JsonProperty(value = "person_name")
    private String name;
    @JsonProperty(value = "person_favoriteColour")
    private String favoriteColour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteColour() {
        return favoriteColour;
    }

    public PersonForm setFavoriteColour(String favoriteColour) {
        this.favoriteColour = favoriteColour;
        return this;
    }
}
