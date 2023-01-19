package com.username918r818.lab4.locations;

import java.util.ArrayList;

import com.username918r818.lab4.entities.Entity;
import com.username918r818.lab4.exceptions.OutOfBounds;

public class House implements Location {
    private static int id = 0;
    private int idOfTheHouse;
    private ArrayList<Entity> entities;
    private final String address;
    private final int boundX, boundY, boundZ;

    public House() {
        this("House" + id);
        this.entities = new ArrayList<Entity>();
    }

    public House(String title) {
        this.address = title;
        this.boundX = this.boundY = this.boundZ = 10;
        idOfTheHouse = id;
        House.id++;
    }

    public String getAddress() {
        return this.address;
    }

    public void getIn(Entity entity, int x, int y, int z) throws OutOfBounds {
        if (x > this.boundX | y > this.boundY | z > this.boundZ) {
            throw new OutOfBounds(address + " out of bounds!");
        }
        if (!this.entities.contains(entity)) {
            this.entities.add(entity);
        }
    }

    public void getOut(Entity entity) {
        if (this.entities.contains(entity)) {
            this.entities.remove(entity);
        }
    }

    public Entity find(String name) {
        for (Entity a : entities) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        return idOfTheHouse;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return address;
    }

    public static void main(String[] args) {
        House house = new House();
        System.out.println(house.getAddress());
    }
}
