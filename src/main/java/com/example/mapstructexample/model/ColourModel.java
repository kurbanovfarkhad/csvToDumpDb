package com.example.mapstructexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"colour_id","colour_colour"})
public class ColourModel extends BaseModel{
    @JsonProperty(value = "colour_id")
    private String id;
    @JsonProperty(value = "colour_colour")
    private String colour;

    public String getId() {
        return id;
    }

    public ColourModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public ColourModel setColour(String colour) {
        this.colour = colour;
        return this;
    }

    @Override
    public String toString() {
        return "ColourModel{" +
                "id='" + id + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
