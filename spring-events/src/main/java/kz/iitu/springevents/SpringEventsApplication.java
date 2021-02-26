package kz.iitu.springevents;

import kz.iitu.springevents.config.SpringConfiguration;
import kz.iitu.springevents.dao.EmployeeDAOImpl;
import kz.iitu.springevents.service.SalaryCalculatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringEventsApplication {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		EmployeeDAOImpl employeeDAO = context.getBean(EmployeeDAOImpl.class);
		SalaryCalculatorService service = context.getBean(SalaryCalculatorService.class);

		int choice = -1;
		while(true){

			System.out.println("1. Create Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Change Salaries");
			System.out.println("4. List of Employees");
			System.out.println("0. Exit");

			System.out.println("Choice -> ");
			choice = in.nextInt();

			switch (choice){
				case 1:
					service.createEmployee(employeeDAO);
					break;
				case 2:
					service.deleteEmployee(employeeDAO);
					break;
				case 3:
					service.changeSalary(employeeDAO);
					break;
				case 4:
					service.listOfEmployee(employeeDAO);
					break;
				case 0:
					System.out.println("Exit");
					return;
			}
		}


	}

}
