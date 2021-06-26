package com.example.login;


public class Profile {
    String email, name , organ;

    public Profile (){

    }

    public Profile(String email, String name, String organ) {
        this.email = email;
        this.name = name;
        this.organ = organ;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getOrgan() {return organ; }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
}
