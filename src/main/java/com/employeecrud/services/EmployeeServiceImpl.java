package com.employeecrud.services;

import com.employeecrud.entities.Employee;
import com.employeecrud.exceptions.EmployeeNotFoundException;
import com.employeecrud.mappers.EmployeeMapper;
import com.employeecrud.models.EmployeeDTO;
import com.employeecrud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(@Qualifier("employeeRepo") EmployeeRepository employeeRepo,
                               @Qualifier("employeeMapper") EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeMapper.employeeDTOS(employeeRepo.findAll());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        if (employeeRepo.findById(id).isPresent()) {
            Employee employee = employeeRepo.findById(id).get();
            return employeeMapper.entityToDTO(employee);
        }
        throw new EmployeeNotFoundException("Employee is not found");
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.entityToDTO(employeeRepo.save(employeeMapper.dtoToEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if (employee.isPresent()){
            employee.get().setFirstName(employeeDTO.getFirstName());
            employee.get().setLastName(employeeDTO.getLastName());
            return employeeMapper.entityToDTO(employeeRepo.save(employee.get()));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepo.findById(id).isPresent()) {
            Employee employee = employeeRepo.findById(id).get();
            String name = employee.getFirstName() +" "+ employee.getLastName();
            employeeRepo.deleteById(id);
            return "Employee : "+ name + " is deleted.";
        }else {
            throw new EmployeeNotFoundException();
        }
    }
}
