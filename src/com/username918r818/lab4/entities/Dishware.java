package com.username918r818.lab4.entities;

public enum Dishware {
    PLATE("Plate"),
    TEAPOT("Teapot");

    private Dishware(String aType) {
        this.aType = aType;
    }

    private final String aType;

    public String type() {
        return aType;
    }
}
