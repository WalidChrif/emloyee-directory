package com.employeecrud.mappers;

import com.employeecrud.entities.Employee;
import com.employeecrud.models.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeMapper")
public class EmployeeMapper {

    public Employee dtoToEntity(EmployeeDTO model){
        Employee employee = new Employee();
        employee.setFirstName(model.getFirstName());
        employee.setLastName(model.getLastName());
        return employee;
    }

    public EmployeeDTO entityToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        return employeeDTO;
    }

    public List<EmployeeDTO> employeeDTOS(List<Employee> employeeList){
        return employeeList.stream().map(this::entityToDTO).toList();
    }
}
