package com.bulentyilmaz.workmanagement.workmanagement.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Tasks")
@Table(name = "tasks")
public class Tasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String workStartDate;
    private String workFinishDate;
    private String workInfo;


    public Tasks() {
    }



    public Tasks(String type, String workStartDate, String workInfo) {
        this.type = type;
        this.workStartDate = workStartDate;
        this.workInfo = workInfo;

    }

    public Tasks(String type, String workStartDate, String workFinishDate, String workInfo, String worksFinishInformation) {
        this.type = type;
        this.workStartDate = workStartDate;
        this.workFinishDate = workFinishDate;
        this.workInfo = workInfo;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getWorkFinishDate() {
        return workFinishDate;
    }

    public void setWorkFinishDate(String workFinishDate) {
        this.workFinishDate = workFinishDate;
    }

    public String getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(String workInfo) {
        this.workInfo = workInfo;
    }


}