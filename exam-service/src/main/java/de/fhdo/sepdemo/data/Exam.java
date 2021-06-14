package de.fhdo.sepdemo.data;

import java.util.UUID;

public class Exam {
    private UUID id;
    private String name;

    //constructor
    public Exam(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    //Getters and setters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
