package org.springsoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springsoft.model.Employee;

/**
 * Created by chaitu on 6/19/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByName(String name);
}
