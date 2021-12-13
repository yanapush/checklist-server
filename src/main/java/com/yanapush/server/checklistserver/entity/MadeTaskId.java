package com.yanapush.server.checklistserver.entity;

import java.io.Serializable;
import java.util.Objects;

public class MadeTaskId implements Serializable {
    private int id;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MadeTaskId)) return false;
        MadeTaskId that = (MadeTaskId) o;
        return id == that.id && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
