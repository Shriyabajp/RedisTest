package com.sreeraj.redistest.RedisTest.utilities;

import com.sreeraj.redistest.RedisTest.model.Employee;
import com.sreeraj.redistest.RedisTest.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sreerajr
 * @package com.sreeraj.mongotest.MongoTest.utilties
 * @project TestMongo
 */
public class UtilityFunctions {
    public static List<EmployeeDto> convertEmployeeListToDtoList(List<Employee> employees) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees)
            employeeDtos.add(new EmployeeDto(employee));
        return employeeDtos;
    }
}
