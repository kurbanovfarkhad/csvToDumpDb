package com.example.mapstructexample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"pet_id","pet_name","pet_type"})
public class PetModel extends BaseModel {
    @JsonProperty(value = "pet_id")
    private String id;
    @JsonProperty(value = "pet_name")
    private String name;
    @JsonProperty(value = "pet_type")
    private String type;

    public String getId() {
        return id;
    }

    public PetModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public PetModel setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
