package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public class Bed extends Entity{

    private Entity sleeping = null;

    public Bed(Location location) {
        this(location, 0, 0, 0);
    }

    public Bed(Location location, int x, int y, int z) {
        super("Bed",location, x, y, z);
    }

    public void layDown(Entity e) {
        if (sleeping == null) e.move(this.position.x, this.position.y, this.position.z, this.position.location);
    }

    public void free() {
        sleeping = null;
    }


}