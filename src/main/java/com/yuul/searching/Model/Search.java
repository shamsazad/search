package com.yuul.searching.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="abc")
public class Search {

    @NotNull
    private String location;
    @Id
    @GeneratedValue
    private int id;

    public int getArea() {
        return Area;
    }

    public void setArea(int area) {
        Area = area;
    }

    @NotNull
    int Area;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
