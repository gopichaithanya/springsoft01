package org.springsoft.service;

import org.springsoft.model.Employee;

import java.util.List;

/**
 * Created by chaitu on 6/19/2017.
 */
public interface EmployeeService {

    Employee findById(Long id);
    Employee findByName(String name);
    void  saveEmployee(Employee employee);
    void  updateEmployee(Employee employee);
    void  deleteEmployeeById(Long id);
    void  deleteAllEmployees();
    List<Employee> findAllEmployees();
    boolean isEmployeeExist(Employee employee);
}
