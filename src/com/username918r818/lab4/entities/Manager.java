package com.username918r818.lab4.entities;
import com.username918r818.lab4.locations.Location;

public class Manager extends Shortman{
    public Manager(String name, Location location) {
        super(name, location, 0, 0, 0, Trait.HEALTHY);
    }

    public Manager(String name, Location location, Trait trait) {
        super(name, location, 0, 0, 0, trait);
    }
    public Manager(String name, Location location, int x, int y, int z, Trait trait) {
        super(name, location, x, y, z, trait);
    }

    public void orderToBring(Shortman s, Entity e) {
        if (s.trait == Trait.ILL || s.trait == Trait.TRICKY) {
            return;
        }
        this.orderToMove(s, e);
        s.get(e);
        this.orderToMove(s, this);
        try {
            s.give(this);
        } catch (Exception exc) {
            this.drop();
            this.orderToBring(s, e);
        }
    }

    public void orderToMove(Shortman s, Entity e) {
        if (s.trait == Trait.ILL || s.trait == Trait.TRICKY) {
            return;
        }
        s.move(e.position.x, e.position.y, e.position.z, e.position.location);
    }

}
