package com.example.androidproject;

public class FacultyUser {
    public String email,id,name,password,phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public FacultyUser(String email, String id, String name, String password,String phone) {
        this.email = email;
        this.id = id;
        this.name = name;

        this.password = password;
        this.phone = phone;
    }
}
