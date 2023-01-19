package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public abstract class Entity {
    protected final String name;
    protected Position position;

    public Entity(String name, Location location) {
        this(name, location, 0, 0, 0);
    }

    public Entity(String name, Location location, int x, int y, int z) {
        this.name = name;
        this.position = new Position(x, y, z, location);
        move(x, y, z, location);
    }

    protected class Position {
        int x, y, z;
        Location location;

        Position(int x, int y, int z, Location location) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.location = location;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || this.getClass() != obj.getClass())
                return false;
            Position a = (Position) obj;
            if (this.x == a.x & this.y == a.y & this.z == a.z & this.location == a.location)
                return true;
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void move(int x, int y, int z, Location location) {
        if (location != this.position.location) {
            this.position.location.getOut(this);
        }
        this.position.location = location;
        this.position.x = x;
        this.position.y = y;
        this.position.z = z;
        this.position.location.getIn(this, x, y, z);
    }

    public void move(int x, int y, int z) {
        this.position.x = x;
        this.position.y = y;
        this.position.z = z;
        this.position.location.getIn(this, x, y, z);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return this.position.x + this.position.y + this.position.z;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null | getClass() != obj.getClass())
            return false;
        Entity e = (Entity) obj;
        if (this.name.equals(e.name) & this.position.equals(e.position))
            return true;
        return false;
    }

}
