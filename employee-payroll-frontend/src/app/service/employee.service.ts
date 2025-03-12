import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root' 
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/employees'; // Base URL for your API

  constructor(private http: HttpClient) {}

  // Get all employees
  getEmployees(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/get/all`);
  }

  // Get employee by ID
  getEmployeeById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get/${id}`);
  }

  // Add a new employee
  addEmployee(employee: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add`, employee);
  }

  // Update employee data (PUT request)
  updateEmployee(id: number, employeeData: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update/${id}`, employeeData);
  }

  // Delete an employee
  deleteEmployee(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${id}`);
  }

  // Get employees from Sales department
  getSalesDepartmentEmployees(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/get/sales`);
  }
}
