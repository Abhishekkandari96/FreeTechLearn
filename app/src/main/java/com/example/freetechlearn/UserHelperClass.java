package com.example.freetechlearn;

public class UserHelperClass {
    String username,name,password,phone,userU;

    public UserHelperClass() {

    }

    public UserHelperClass(String username, String name, String password, String phone ,String userU ) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone=phone;
        this.userU=userU;
    }

    public String getUserU() {
        return userU;
    }

    public void setUserU(String userU) {
        this.userU = userU;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String password) {
        this.phone = phone;
    }
}
