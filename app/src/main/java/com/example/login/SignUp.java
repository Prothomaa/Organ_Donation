package com.example.login;

public class SignUp {
    String user , emaill , pass , dobr ;

    public SignUp(){

    }

    public SignUp(String user, String emaill, String pass, String dobr) {
        this.user = user;
        this.emaill = emaill;
        this.pass = pass;
        this.dobr = dobr;
    }

    public String getUser() {
        return user;
    }

    public String getEmaill() {
        return emaill;
    }

    public String getPass() {
        return pass;
    }

    public String getDobr() {
        return dobr;
    }
}
