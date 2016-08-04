package com.example.messaging;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by KZO on 19/07/2016.
 */

public class Employee extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String code;
    private String department;

    public Employee() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
