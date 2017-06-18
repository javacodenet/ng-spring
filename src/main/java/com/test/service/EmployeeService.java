package com.test.service;

import com.test.dto.EmployeeDTO;
import com.test.entity.Employee;
import com.test.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(this::getEmployeeDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO getEmployeeDTO(Employee e) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(e.getId());
        employeeDTO.setName(e.getName());
        employeeDTO.setCompany(e.getCompany());
        return employeeDTO;
    }

    public boolean saveEmployee(EmployeeDTO employeeDto) {
        employeeRepository.save(getEmployee(employeeDto));
        return true;
    }

    private Employee getEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setCompany(employeeDto.getCompany());
        return employee;
    }

    public boolean updateEmployee(EmployeeDTO employee) {
        employeeRepository.save(getEmployee(employee));
        return true;
    }

    public boolean deleteEmployee(Integer id) {
        employeeRepository.delete(id.toString());
        return true;
    }
}
