package kz.iitu.springevents.service;

import kz.iitu.springevents.dao.EmployeeDAOImpl;
import kz.iitu.springevents.user.Employee;
import kz.iitu.springevents.user.EmployeeType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class SalaryCalculatorService {
    Scanner in = new Scanner(System.in);

    public void createEmployee(EmployeeDAOImpl employeeDAO){

        System.out.println("Choose User Type: ");
        System.out.println("1." + EmployeeType.Type1);
        System.out.println("2." + EmployeeType.Type2);
        System.out.println("3." + EmployeeType.Type3);
        System.out.println("4." + EmployeeType.Type4);
        System.out.print("Choice : ");
        int choice = in.nextInt();
        EmployeeType type;
        switch (choice){
            case 1:
                type = EmployeeType.Type1;
                break;
            case 2:
                type = EmployeeType.Type2;
                break;
            case 3:
                type = EmployeeType.Type3;
                break;
            case 4:
                type = EmployeeType.Type4;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        System.out.println("Enter id: ");
        int id = in.nextInt();
        System.out.println("Enter name: ");
        String name = in.next();
        System.out.println("Enter surname: ");
        String surname = in.next();
        System.out.println("Enter username: ");
        String username = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        System.out.println("Enter salary: ");
        int salary = in.nextInt();

        employeeDAO.create(type, id, name, surname, username, password,salary);
    }

    public void deleteEmployee(EmployeeDAOImpl employeeDAO){
        System.out.println("Enter id of Employee : ");
        int id = in.nextInt();
        employeeDAO.delete(id);
    }

    public void changeSalary(EmployeeDAOImpl employeeDAO){
        System.out.println("Enter id of Employee");
        int id = in.nextInt();
        System.out.println("--------------------------------------");
        Employee employee = employeeDAO.getEmployee(id);
        int oldSalary = employee.getSalary();

        System.out.println("Information about this Employee: ");
        System.out.println(employee.toString());
        System.out.println("--------------------------------------");

        System.out.println("If you want to increase choose '1'");
        System.out.println("If you want to decrease choose '2'");
        System.out.print("Choice -> ");
        int choice = in.nextInt();
        if(choice == 1){
            System.out.print("How many percent (%) you want to increase? ->");
            int per = in.nextInt();
            employeeDAO.changeSalary(id, oldSalary + oldSalary * per / 100);
        }else{
            System.out.print("How many percent (%) you want to decrease? ->");
            int per = in.nextInt();
            employeeDAO.changeSalary(id, oldSalary - oldSalary * per / 100);
        }
    }

    public void listOfEmployee(EmployeeDAOImpl employeeDAO){
        List<Employee> employees = employeeDAO.listEmployees();
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

}
