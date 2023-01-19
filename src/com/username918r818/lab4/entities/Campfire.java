package com.username918r818.lab4.entities;

import com.username918r818.lab4.locations.Location;

public class Campfire extends Entity{

    public Campfire(Location location) {
        this(location, 0, 0, 0);
    }

    public Campfire(Location location, int x, int y, int z) {
        super("Campfire",location, x, y, z);
        System.out.println("The fire lit up!");

    }

    public static class Cookbook {
        private static Food cauldron = null;
        public static void cook(Food food) {
            System.out.println("Готовится " +  food.getName());
            cauldron = food;
        }
        public static Food pourFrom() {
            System.out.println("Из котелка сливаем " + cauldron.getName());
            Food a = cauldron;
            cauldron = null;
            return a;
        }
    }


}