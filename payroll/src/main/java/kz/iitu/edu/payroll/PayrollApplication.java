package kz.iitu.edu.payroll;

import kz.iitu.edu.payroll.config.SpringConfiguration;
import kz.iitu.edu.payroll.controller.MainController;
import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;
import kz.iitu.edu.payroll.service.impl.PayrollService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Scanner in = new Scanner(System.in);

        MainController controller = context.getBean("mainController", MainController.class);
        PayrollService service = context.getBean("payrollService", PayrollService.class);

        while(true){
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Increase Employee's salary");
            System.out.println("4. List of Employees by Type");
            System.out.println("5. List of Employees");
            System.out.println("0. Exit");

            System.out.print("Choice -> ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    service.createEmployee(controller);
                    break;
                case 2:
                    service.deleteEmployee(controller);
                    break;
                case 3:
                    service.increaseSalary(controller);
                    break;
                case 4:
                    service.listOfEmployeesByType(controller);
                    break;
                case 5:
                    service.listOfAllEmployees(controller);
                    break;
                case 0:
                    System.out.println("EXIT");
                    return;
                default:
                    System.out.println("Incorrect choice! Please try again!");
                    break;
            }
            System.out.println();
        }

    }

}
