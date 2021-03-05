package kz.iitu.edu.payroll.controller;

import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;
import kz.iitu.edu.payroll.service.IEmployeeService;
import kz.iitu.edu.payroll.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IEmployeeService iEmployeeService;

    public List<Employee> getAllByType(EmployeeType type){
        return iEmployeeService.getEmployeesByEmplType(type);
    }

    public List<Employee> getAll(){
        return iEmployeeService.getAll();
    }

    public void create(Employee employee){
        iEmployeeService.create(employee);
    }

    public void update(Long id, Employee employee){
        iEmployeeService.update(id, employee);
    }

    public void delete(Long id){
        iEmployeeService.delete(id);
    }

    public Employee getEmployeeById(Long id){
        return iEmployeeService.getEmployeeById(id);
    }
}
