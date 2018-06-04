package com.sreeraj.redistest.RedisTest.controller;


import com.sreeraj.redistest.RedisTest.dto.EmployeeDto;
import com.sreeraj.redistest.RedisTest.exceptions.EmployeeIdNotFoundException;
import com.sreeraj.redistest.RedisTest.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employee")
public class EmployeeController{

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }


    @RequestMapping(value = "/get-json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getEmployeeAsJson(@RequestParam String id) {
        return getEmployee(id);
    }

    @RequestMapping(value = "/get-xml", produces = {MediaType.APPLICATION_XHTML_XML_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeAsXml(@RequestParam String id) {
        return getEmployee(id);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@RequestParam String id) {
        try {
            return employeeService.getEmployee(id);
        } catch (EmployeeIdNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Employee id " + id + " does not exist", HttpStatus.OK);
        }
    }
    /*
    @RequestMapping(value = "/get-by-firstname", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDto>> getEmployeesByFirstName(@RequestParam(name = "first-name") String firstName) {
        return employeeService.getEmployeesByFirstName(firstName);
    }

    @RequestMapping(value = "/get-by-lastname", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDto>> getEmployeesByLastName(@RequestParam(name = "last-name") String lastName) {
        return employeeService.getEmployeesByLastName(lastName);
    }
    */

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployeeById(@RequestParam String id, @RequestBody EmployeeDto employeeDto) {
        try {
            return employeeService.updateEmployeeById(id, employeeDto);
        } catch (EmployeeIdNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Employee id " + id + " does not exist", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@RequestParam String id) {
        try {
            return employeeService.deleteEmployee(id);
        } catch (EmployeeIdNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Employee id " + id + " does not exist", HttpStatus.OK);
        }
    }
}
