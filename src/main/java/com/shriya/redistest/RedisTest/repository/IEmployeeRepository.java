package com.sreeraj.redistest.RedisTest.repository;


import com.sreeraj.redistest.RedisTest.model.Employee;

import java.util.List;
import java.util.Optional;


public interface IEmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(String id);
    void deleteById(String id);
    //List<Employee> findByFirstName(String firstName);
    //List<Employee> findByLastName(String lastName);
}