package kz.iitu.edu.payroll.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fixedSalary")
    private double fixedSalary;

    @Column(name = "hour_rate")
    private double hourRate;

    @Column(name = "hours_worked")
    private int hoursWorked;

    @Column(name = "comm_rate")
    private float commRate;

    @Column(name = "employee_type")
    private EmployeeType emplType;

}
