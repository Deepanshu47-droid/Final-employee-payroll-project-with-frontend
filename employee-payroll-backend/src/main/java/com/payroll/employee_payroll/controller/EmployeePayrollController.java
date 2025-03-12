package com.payroll.employee_payroll.controller;

import com.payroll.employee_payroll.dto.EmployeeDTO;
import com.payroll.employee_payroll.model.EmployeeEntity;
import com.payroll.employee_payroll.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeeService employeeService;

    // ✅ Get all employees
    @GetMapping("/get/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // ✅ Get employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // ✅ Add new employee (using EmployeeDTO)
    @PostMapping("/add")
    public ResponseEntity<EmployeeEntity> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Adding Employee: {}", employeeDTO);
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));
    }

    // ✅ Update employee (using EmployeeDTO)
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

    // ✅ Delete employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    // ✅ Get Sales department employees
    @GetMapping("/get/{department}")
    public ResponseEntity<List<EmployeeEntity>> getDepartmentEmployees(@PathVariable @Valid String department) {
        log.info("Fetching employees from Sales department...");
        return ResponseEntity.ok(employeeService.getDepartmentEmployees(department));
    }
}
