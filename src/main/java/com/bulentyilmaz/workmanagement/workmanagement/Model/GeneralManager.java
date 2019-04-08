package com.bulentyilmaz.workmanagement.workmanagement.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "GeneralManager")
@Table(name="aviva_manager")
public class GeneralManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String email;
    private String password;
    private String birthday;
    private int age;


    public GeneralManager() { }

    public GeneralManager(String name, String email, String password, String birthday, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String  getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}
