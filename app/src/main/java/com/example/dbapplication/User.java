package com.example.dbapplication;

import java.io.Serializable;

public class User implements Serializable {
  private   long id; //primary key
  private   String name;
  private   String email;

    public User( String name, String email) {

        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
