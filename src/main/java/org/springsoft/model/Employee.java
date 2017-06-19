package org.springsoft.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chaitu on 6/19/2017.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  Id;
    @Column(name="EMPLOYEE_NAME")
    private  String name;
    @Column(name="JOB")
    private  String  job;
    @Column(name="SALARY")
    private  Float  salary;
    @Column(name="ADDRESS")
    private  String address;
    @Column(name="EMAIL")
    private  String email;
    @Column(name="PHONE")
    private  String phone;
    @Column(name="STATE")
    private  String state;
    @Column(name="ZIPCODE")
    private  String zipcode;
    @Column(name="COUNTRY")
    private  String country;

    public Employee(){

    }
    public Employee(String name, String job, Float salary, String address, String email, String phone, String state, String zipcode, String country) {
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
