package com.example.login;

public class Request {
    String date , email , organ ;

    public Request(){

    }

    public Request(String date, String email, String organ) {
        this.date = date;
        this.email= email;
        this.organ = organ;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getOrgan() {
        return organ;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
}
