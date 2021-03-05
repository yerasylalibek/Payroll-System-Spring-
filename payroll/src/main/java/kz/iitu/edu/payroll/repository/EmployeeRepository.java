package kz.iitu.edu.payroll.repository;

import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getById(Long id);
    List<Employee> getEmployeesByEmplType(EmployeeType type);
    List<Employee> getAllBy();

}
