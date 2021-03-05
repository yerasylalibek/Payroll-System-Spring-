package kz.iitu.edu.payroll.event;


import kz.iitu.edu.payroll.model.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {

    private Employee employee;

    public SalaryChangeEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
