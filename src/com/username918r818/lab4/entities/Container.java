package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public class Container extends Entity{
    private static int id = 0;
    private int idOfTheDish;
    private final Dishware dishware;
    private Food food = null;
    

    public Container(String name, Location location) {
        super(name, location, 0, 0, 0);
        this.dishware = Dishware.PLATE;

    }

    public Container(String name, Location location, int x, int y, int z) {
        super(name, location, x, y, z);
        this.dishware = Dishware.TEAPOT;
    }

    public Container(Location location) {
        super(Dishware.PLATE.type() + id, location, 0, 0, 0);
        this.idOfTheDish = id;
        Container.id++;
        this.dishware = Dishware.PLATE;


    }

    public Container(Location location, int x, int y, int z) {
        super(Dishware.TEAPOT.type() + id, location, x, y, z);
        this.idOfTheDish = id;
        Container.id++;
        this.dishware = Dishware.TEAPOT;
    }

    public Food getFood() {
        return this.food;
    }

    public void fill(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        if ((dishware.type() + id).equals(name))
            return name;
        return dishware.type() + id + ": " + name;
    }

    @Override
    public int hashCode() {
        return this.idOfTheDish;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }
}
