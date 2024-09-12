package com.employeecrud.repositories;

import com.employeecrud.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepo")
//@RepositoryRestResource(path = "members")
//we can use repo directly if we comment-out service and controller layers
//this repo will also give us endpoints: urlMappings
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
