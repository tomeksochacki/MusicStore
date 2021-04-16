package pl.it.camp.music.store.model;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private String login;
    private String password;
    private String name;
    private String sureName;
    private String age;
    private String phoneNumber;

    public User(String login, String password, String name, String sureName, String age, String phoneNumber){
        this.login = login;
        this.password = password;
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.phoneNumber = phoneNumber;

        //this.userId = userId++;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
