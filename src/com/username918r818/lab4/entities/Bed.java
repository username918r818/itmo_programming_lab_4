package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public class Bed extends Entity{

    private Entity sleeping = null;

    public Bed(Location location) {
        this(location, 0, 0, 0);
    }

    public Bed(Location location, int x, int y, int z) {
        super("Bed",location, x, y, z);
        System.out.println("Magic bed appeared!");
    }

    public void layDown(Entity e) {
        if (sleeping == null) {
            e.move(this.position.x, this.position.y, this.position.z, this.position.location);
            System.out.println("Приляг, братишка, отдохни");
            System.out.println(e.getName() + " лежит");
        }
    }

    public void free() {
        if (sleeping != null) {
            System.out.println("С пробуждением, солнце!");
            System.out.println(sleeping.getName() + " встает с кроватки!");
        }
        sleeping = null;
    }


}