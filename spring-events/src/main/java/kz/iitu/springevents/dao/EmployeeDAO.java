package kz.iitu.springevents.dao;

import kz.iitu.springevents.user.Employee;
import kz.iitu.springevents.user.EmployeeType;

import java.util.List;

public interface EmployeeDAO {

    void create(EmployeeType type, int id, String name, String surname, String username, String password, int salary);

    void delete(int id);

    void changeSalary(int id, int newSalary);

    Employee getEmployee(int id);

    List<Employee> listEmployees();

}
