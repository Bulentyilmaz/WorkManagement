package com.bulentyilmaz.workmanagement.workmanagement.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity(name = "Employees")
@Table(name = "employees")
public class Employees implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private int age;
    private String departman;




    public Employees() { }


    public Employees(String name, String email, String password, String birthday, int age, String departman) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
        this.departman = departman;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getDepartman() { return departman; }

    public void setDepartman(String departman) { this.departman = departman; }


}

