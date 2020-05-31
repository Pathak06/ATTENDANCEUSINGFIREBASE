package com.example.androidproject;


public class User {
    public String email,id,name,password,phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(){

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User( String email,String id,String name, String password, String phone) {
        this.email = email;
        this.id = id;
        this.name = name;

        this.password = password;
        this.phone = phone;
    }
    public String toString(){
        return this.id + "." + name;
    }

}
