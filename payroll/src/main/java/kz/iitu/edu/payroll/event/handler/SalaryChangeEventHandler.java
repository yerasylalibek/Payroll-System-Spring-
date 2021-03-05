package kz.iitu.edu.payroll.event.handler;


import kz.iitu.edu.payroll.event.SalaryChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {

        System.out.println("Changed Employee's salary: " + salaryChangeEvent.getEmployee());

    }
}
