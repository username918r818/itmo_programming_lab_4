package com.username918r818.lab4.entities;

import com.username918r818.lab4.exceptions.CantGive;
import com.username918r818.lab4.locations.House;
import com.username918r818.lab4.locations.Location;

public class Shortman extends Entity {
    protected Entity grabbed;
    protected Trait trait;

    public Shortman(String name, Location location) {
        this(name, location, 0, 0, 0, Trait.HEALTHY);
    }

    public Shortman(String name, Location location, Trait trait) {
        this(name, location, 0, 0, 0, trait);
    }

    public Shortman(String name, Location location, int x, int y, int z, Trait trait) {
        super(name, location, x, y, z);
        this.trait = trait;
        grabbed = null;
        System.out.println(name + " заспавнился!");
    }

    public Entity find(String name) {
        System.out.println(name + " is looking for " + name + "...");
        return this.position.location.find(name);
    }

    public void get(Entity e) {
        System.out.println(name + " берет " + e.getName());
        this.grabbed = e;
    }

    public void get(String name) {
        System.out.println(this.name + " захотел взять " + name);
        this.grabbed = this.position.location.find(name);
        if (this.grabbed == null) {
            System.out.println("В другом месте поищи!");
        }
    }

    public void give(Shortman s) throws CantGive {
        System.out.println(name + " отдает " + s.name + " " + this.grabbed.getName());
        if (s.grabbed != null) {
            System.out.println("Некуда класть!");
            throw new CantGive(name + " cant give");
        } else {
            s.get(this.grabbed);
            this.drop();
        }
    }

    public void drop() {
        this.grabbed = null;
    }

    public void eat(Container c) {
        if (c == this.grabbed && c.getFood() != null) {
            System.out.println(name + " кушоет " + c.getFood().getName()  + " из " + this.grabbed.getName());
            if (this.trait == Trait.ILL) {
                this.trait = Trait.HEALTHY;
            }
        }
    }

    public void fill(Container c, Food f) {
        if (c == this.grabbed) {
            System.out.println(name + " плотно наваливает " + f.getName() + " в " + this.grabbed.getName());
            c.fill(f);
        }
    }

    @Override
    public void move(int x, int y, int z, Location location) {
        super.move(x, y, z, location);
        if (this.grabbed != null && !this.grabbed.position.equals(this.position)) {
            this.grabbed.move(x, y, z, location);
        }
    }

    @Override
    public void move(int x, int y, int z) {
        super.move(x, y, z);
        if (this.grabbed != null && !this.grabbed.position.equals(this.position)) {
            this.grabbed.move(x, y, z);
        }
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
        if (obj == null || getClass() != obj.getClass())
            return false;
        Entity e = (Entity) obj;
        if (this.name.equals(e.name) & this.position.equals(e.position))
            return true;
        return false;
    }

    public static void main(String[] args) {

        House house = new House();
        Container boiler = new Container("boi1er", house);
        Container boiler5 = new Container("boiler2", house);
        Container teapot = new Container(house);
        Shortman lesya = new Shortman("lesya", house);
        Shortman vasya = new Shortman("null", house);
        Shortman lena = new Shortman("lena", house);

        lesya.get(teapot);
        System.out.println(lesya.grabbed == teapot);

        vasya.get("boi1er");
        System.out.println(vasya.grabbed.name);

        lena.get(boiler5);
        System.out.println(lena.grabbed.name);
        try {
            vasya.give(lena);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lena.grabbed.name);
        try {
            vasya.give(lena);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lena.grabbed.name);
        lena.drop();
        try {
            vasya.give(lena);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lena.grabbed.name);
        lena.drop();
        System.out.println(lena.grabbed);
        vasya.get(boiler.getName());
        System.out.println(vasya.grabbed);
        System.out.println(vasya.grabbed.getName());
        vasya.get(boiler.getName());
        System.out.println(boiler.getName());
        System.out.println(vasya.grabbed == boiler);
        System.out.println(vasya.grabbed == boiler5);
        vasya.get(boiler5);
        System.out.println(vasya.grabbed == boiler);
        System.out.println(vasya.grabbed == boiler5);

    }

}
