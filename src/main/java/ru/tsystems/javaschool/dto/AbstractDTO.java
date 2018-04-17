package ru.tsystems.javaschool.dto;

import java.io.Serializable;

public abstract class AbstractDTO<E> implements Serializable {
    protected int id;

    public abstract void apply(E entity);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
