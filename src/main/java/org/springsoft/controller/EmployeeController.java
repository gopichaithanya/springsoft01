package org.springsoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springsoft.model.Employee;
import org.springsoft.service.EmployeeService;
import org.springsoft.util.CustomErrorType;

import java.util.List;

/**
 * Created by chaitu on 6/19/2017.
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    public static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;


    @RequestMapping(value = "/employee/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    // -------------------Retrieve Single User------------------------------------------



    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        logger.info("Fetching Employee with id {}", id);
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            logger.error("Employee  with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Employee with id" +id+"not found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------


    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Employee : {}", employee);

        if (employeeService.isEmployeeExist(employee)) {
            logger.error("Unable to create. A Employee with name {} already exist", employee.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Employee with name " +
                    employee.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        employeeService.saveEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------


    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        logger.info("Updating User with id {}", id);

        Employee currentEmployee = employeeService.findById(id);

        if (currentEmployee == null) {
            logger.error("Unable to update. Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Employee with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentEmployee.setName(employee.getName());
        currentEmployee.setJob(employee.getJob());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setAddress(employee.getAddress());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setPhone(employee.getPhone());
        currentEmployee.setState(employee.getState());
        currentEmployee.setZipcode(employee.getZipcode());
        currentEmployee.setCountry(employee.getCountry());


        employeeService.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------
    @SuppressWarnings({"unchecked","rawtype"})
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Employee with id {}", id);

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            logger.error("Unable to delete. employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Employee with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------



    @RequestMapping(value = "/employee/", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteAllEmployees() {
        logger.info("Deleting All Employees");

        employeeService.deleteAllEmployees();
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
