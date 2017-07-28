package com.james.jspdemo.entity;

/**
 * Created by fsuser on 2017-07-17.
 */
public class Employee {

    private String id;
    private String name;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

