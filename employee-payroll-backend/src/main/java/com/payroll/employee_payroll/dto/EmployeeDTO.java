package com.payroll.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Name must start with an uppercase letter and contain only alphabets and spaces")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 10000, message = "Salary must be greater than 10000")
    private double salary;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    @NotEmpty(message = "Message must have some key points")
    private String note;

    @JsonFormat(pattern = "yyyy-MM-dd")  // Changed to match Angular's date format
    @NotNull(message = "Start Date should not be empty!")
    @PastOrPresent(message = "Start Date should be past or today's date")
    private LocalDate startDate;

    @NotEmpty(message = "Profile Pic must have a URL of an image")
    private String profilePic;

    @NotEmpty(message = "List of Departments must have at least one department")
    private List<String> department;

}
