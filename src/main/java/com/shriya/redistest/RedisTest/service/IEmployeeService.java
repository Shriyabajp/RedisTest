package com.sreeraj.redistest.RedisTest.service;

import com.sreeraj.redistest.RedisTest.dto.EmployeeDto;
import com.sreeraj.redistest.RedisTest.exceptions.EmployeeIdNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    ResponseEntity<EmployeeDto> createEmployee(EmployeeDto emp);

    ResponseEntity<EmployeeDto> getEmployee(String id) throws EmployeeIdNotFoundException;

    ResponseEntity<String> deleteEmployee(String id) throws EmployeeIdNotFoundException;

    //ResponseEntity<List<EmployeeDto>> getEmployeesByFirstName(String firstName);

    //ResponseEntity<List<EmployeeDto>> getEmployeesByLastName(String lastName);

    ResponseEntity<EmployeeDto> updateEmployeeById(String id, EmployeeDto employeeDto) throws EmployeeIdNotFoundException;

}