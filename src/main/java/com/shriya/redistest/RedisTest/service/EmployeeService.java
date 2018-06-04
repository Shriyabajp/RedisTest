package com.sreeraj.redistest.RedisTest.service;


import com.sreeraj.redistest.RedisTest.model.Employee;
import com.sreeraj.redistest.RedisTest.dto.EmployeeDto;
import com.sreeraj.redistest.RedisTest.exceptions.EmployeeIdNotFoundException;
import com.sreeraj.redistest.RedisTest.repository.IEmployeeRepository;
import com.sreeraj.redistest.RedisTest.utilities.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {


    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    @Transactional
    public ResponseEntity<EmployeeDto> createEmployee(EmployeeDto emp) {
        EmployeeDto employeeDto = new EmployeeDto(employeeRepository.save(new Employee(emp)));
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<EmployeeDto> getEmployee(String id) throws EmployeeIdNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent())
            throw new EmployeeIdNotFoundException("id does not exist");
        return new ResponseEntity<>(new EmployeeDto(employee.get()), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteEmployee(String id) throws EmployeeIdNotFoundException {
        if (!employeeRepository.findById(id).isPresent()) {
            throw new EmployeeIdNotFoundException("id does not exist");
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<>("Deleted " + id, HttpStatus.OK);
    }

    /*@Override
    @Transactional
    public ResponseEntity<List<EmployeeDto>> getEmployeesByFirstName(String firstName) {
        List<EmployeeDto> employeeDtos = UtilityFunctions.convertEmployeeListToDtoList(employeeRepository.findByFirstName(firstName));
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<List<EmployeeDto>> getEmployeesByLastName(String lastName) {
        List<EmployeeDto> employeeDtos = UtilityFunctions.convertEmployeeListToDtoList(employeeRepository.findByLastName(lastName));
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }
    */

    @Override
    @Transactional
    public ResponseEntity<EmployeeDto> updateEmployeeById(String id, EmployeeDto employeeDto) throws EmployeeIdNotFoundException {
        if (!employeeRepository.findById(id).isPresent())
            throw new EmployeeIdNotFoundException("id does not exist");
        Employee employee = employeeRepository.findById(id).get();
        if (null != (employeeDto.getFirstName())) employee.setFirstName(employeeDto.getFirstName());
        if (null != (employeeDto.getLastName())) employee.setLastName(employeeDto.getLastName());
        if (null != (employeeDto.getAge())) employee.setAge(employeeDto.getAge());
        return new ResponseEntity<>(new EmployeeDto(employeeRepository.save(employee)), HttpStatus.OK);
    }

}

