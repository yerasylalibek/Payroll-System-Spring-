package kz.iitu.edu.payroll.service.impl;

import kz.iitu.edu.payroll.controller.MainController;
import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Component
@Service
public class PayrollService {

    Scanner in = new Scanner(System.in);

    public void createEmployee(MainController controller){
        Employee employee = new Employee();

        System.out.println("Enter name: ");
        employee.setName(in.next());
        System.out.println("Enter fixed salary: ");
        employee.setFixedSalary(in.nextDouble());
        System.out.println("Enter hour rate: ");
        employee.setHourRate(in.nextDouble());
        System.out.println("Enter hours worked: ");
        employee.setHoursWorked(in.nextInt());
        System.out.println("Enter comm rate: ");
        employee.setCommRate(in.nextFloat());
        System.out.println("Choose Employee type : ");

        EmployeeType employeeType = null;
        int u;
        System.out.println("1." + EmployeeType.SALARIED_COMMISSION.name());
        System.out.println("2." + EmployeeType.SALARIED.name());
        System.out.println("3." + EmployeeType.COMMISSION.name());
        System.out.println("4." + EmployeeType.HOURLY.name());
        System.out.print("Choice -> ");
        u = in.nextInt();

        switch (u){
            case 1:
                employeeType = EmployeeType.SALARIED_COMMISSION;
                break;
            case 2:
                employeeType = EmployeeType.SALARIED;
                break;
            case 3:
                employeeType = EmployeeType.COMMISSION;
                break;
            case 4:
                employeeType = EmployeeType.HOURLY;
                break;
        }
        employee.setEmplType(employeeType);

        controller.create(employee);
        System.out.println("User created!");
    }

    public void deleteEmployee(MainController controller){
        System.out.println("Enter id of Employee: ");
        Long id = in.nextLong();
        controller.delete(id);
        System.out.println("User deleted! ");
    }

    public void listOfEmployeesByType(MainController controller){

        EmployeeType employeeType = null;
        int u;
        System.out.println("1." + EmployeeType.SALARIED_COMMISSION.name());
        System.out.println("2." + EmployeeType.SALARIED.name());
        System.out.println("3." + EmployeeType.COMMISSION.name());
        System.out.println("4." + EmployeeType.HOURLY.name());
        System.out.print("Choice -> ");
        u = in.nextInt();

        switch (u){
            case 1:
                employeeType = EmployeeType.SALARIED_COMMISSION;
                break;
            case 2:
                employeeType = EmployeeType.SALARIED;
                break;
            case 3:
                employeeType = EmployeeType.COMMISSION;
                break;
            case 4:
                employeeType = EmployeeType.HOURLY;
                break;
        }

        List<Employee> employees = controller.getAllByType(employeeType);
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    public void listOfAllEmployees(MainController controller){
        List<Employee> employees = controller.getAll();
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    public void increaseSalary(MainController controller){
        System.out.println("Enter id of Employee: ");
        Long id = in.nextLong();
        System.out.println("Enter how many percent you want to increase? ");
        double salary = in.nextDouble();

        Employee employee = controller.getEmployeeById(id);

        double newSalary = employee.getFixedSalary() + employee.getFixedSalary() * salary/100;
        employee.setFixedSalary(newSalary);

        controller.update(id, employee);
        System.out.println("Updated!");
    }
}
