package com.example.mapstructexample.model;

public class PetModel extends BaseModel {
    private String id;
    private String name;
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
