package com.payroll.employee_payroll.service;

import com.payroll.employee_payroll.dto.EmployeeDTO;
import com.payroll.employee_payroll.exception.EmployeeNotFoundException;
import com.payroll.employee_payroll.model.EmployeeEntity;
import com.payroll.employee_payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = mapDtoToEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setNote(employeeDTO.getNote());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setProfilePic(employeeDTO.getProfilePic());

        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        log.debug("Deleting the Employee Whose id is {}" , id);
        // Remove employee with the given ID
        if((employeeRepository.existsById(id))) {
            employeeRepository.deleteById(id);
            return true;
        }
        // return false for employee not found with given id
        return false;
    }

    @Override
    public List<EmployeeEntity> getDepartmentEmployees(String department) {
        List<EmployeeEntity> salesEmployees = employeeRepository.findByDepartment();
        if (salesEmployees.isEmpty()) {
            log.warn("No employees found in the Sales department.");
        }
        return salesEmployees;
    }

    // Helper method to map DTO to Entity
    private EmployeeEntity mapDtoToEntity(EmployeeDTO dto) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        employee.setGender(dto.getGender());
        employee.setNote(dto.getNote());
        employee.setStartDate(dto.getStartDate());
        employee.setDepartment(dto.getDepartment());
        employee.setProfilePic(dto.getProfilePic());
        return employee;
    }
}
