package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public class Campfire extends Entity{

    public Campfire(Location location) {
        this(location, 0, 0, 0);
    }

    public Campfire(Location location, int x, int y, int z) {
        super("Campfire",location, x, y, z);
    }

    public static class Cookbook {
        private static Food cauldron = null;
        public static void cook(Food food) {
            cauldron = food;
        }
        public static Food pourFrom() {
            Food a = cauldron;
            cauldron = null;
            return a;
        }
    }


}