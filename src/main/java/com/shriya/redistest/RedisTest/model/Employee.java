package com.sreeraj.redistest.RedisTest.model;

import com.sreeraj.redistest.RedisTest.dto.EmployeeDto;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;


public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private Integer age;

    @Id
    private String id;

    public Employee(String firstName, String lastName, Integer age, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public Employee() {
    }

    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.id = employeeDto.getId();
        this.age = employeeDto.getAge();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, age, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }


}
