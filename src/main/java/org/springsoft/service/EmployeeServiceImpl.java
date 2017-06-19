package org.springsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springsoft.Repository.EmployeeRepository;
import org.springsoft.model.Employee;

import java.util.List;

/**
 * Created by chaitu on 6/19/2017.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id) ;
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
         saveEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void deleteAllEmployees() {
      employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean isEmployeeExist(Employee employee) {
        return findByName(employee.getName())!=null;
    }
}
