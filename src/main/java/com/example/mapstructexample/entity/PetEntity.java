package com.example.mapstructexample.entity;

public class PetEntity extends BaseEntity {
    private String id;
    private String name;
    private String type;

    @Override
    public String toString() {
        return "PetEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public PetEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public PetEntity setType(String type) {
        this.type = type;
        return this;
    }
}
