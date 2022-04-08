package com.example.mapstructexample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ColourEntity extends BaseEntity {
    @Id
    private String id;
    private String colour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "ColourEntity{" +
                "id='" + id + '\'' +
                ", type='" + colour + '\'' +
                '}';
    }
}
