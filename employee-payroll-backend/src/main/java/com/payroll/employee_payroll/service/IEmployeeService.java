package com.payroll.employee_payroll.service;

import com.payroll.employee_payroll.dto.EmployeeDTO;
import com.payroll.employee_payroll.model.EmployeeEntity;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity addEmployee(EmployeeDTO employeeDTO);

    EmployeeEntity getEmployeeById(Long id);

    EmployeeEntity updateEmployee(Long id, EmployeeDTO employeeDTO);

    boolean deleteEmployee(Long id);

    List<EmployeeEntity> getDepartmentEmployees(String department);
}
