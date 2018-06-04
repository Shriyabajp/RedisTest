package com.sreeraj.redistest.RedisTest.repository;

import com.sreeraj.redistest.RedisTest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * @author sreerajr
 * @package com.sreeraj.redistest.RedisTest.repository
 * @project RedisTest
 */

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private static final String KEY = "EMPLOYEE";

    private RedisTemplate<String, Employee> redisTemplate;
    private HashOperations<String, String, Employee> hashOperations;

    @Autowired
    public EmployeeRepository(RedisTemplate<String, Employee> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Employee save(Employee employee) {
        hashOperations.put(KEY, employee.getId(), employee);
        return findById(employee.getId()).get();
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(hashOperations.get(KEY, id));
    }

    @Override
    public void deleteById(String id) {
        hashOperations.delete(KEY, id);
    }

    /*@Override
    public List<Employee> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return null;
    }
*/
}
