package io.egen.entity;

/**
 * Created by Ajith on 5/30/2017.
 */

    public enum Priority
    {

            LOW(0), MEDIUM(1),HIGH(2);

            private final int id;
            Priority(int id) { this.id = id; }
            public int getValue() { return id; }

    }

