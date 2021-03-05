package kz.iitu.edu.payroll.service;

import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;

import java.util.List;

public interface IEmployeeService {

    void create(Employee employee);
    void delete(Long id);
    void update(Long id, Employee employee);
    List<Employee> getEmployeesByEmplType(EmployeeType type);
    List<Employee> getAll();
    Employee getEmployeeById(Long id);


}
