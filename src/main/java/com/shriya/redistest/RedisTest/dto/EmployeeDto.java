package com.sreeraj.redistest.RedisTest.dto;

import com.sreeraj.redistest.RedisTest.model.Employee;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private String id;

    public EmployeeDto(String id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public EmployeeDto(Employee employee) {
        this.age = employee.getAge();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.id = employee.getId();
    }

    public EmployeeDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
