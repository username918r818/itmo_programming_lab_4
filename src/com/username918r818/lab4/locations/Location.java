package com.username918r818.lab4.locations;

import com.username918r818.lab4.entities.Entity;

public interface Location {
    String getAddress();

    void getIn(Entity entity, int x, int y, int z);

    void getOut(Entity entity);

    Entity find(String name);
}
