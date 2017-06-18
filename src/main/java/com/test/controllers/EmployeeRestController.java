package com.test.controllers;

import com.test.dto.EmployeeDTO;
import com.test.service.EmployeeService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeDTO> list() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean updateEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean saveEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public boolean deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

}
