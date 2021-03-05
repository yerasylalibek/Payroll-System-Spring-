package kz.iitu.edu.payroll.service.impl;

import kz.iitu.edu.payroll.model.Employee;
import kz.iitu.edu.payroll.model.EmployeeType;
import kz.iitu.edu.payroll.repository.EmployeeRepository;
import kz.iitu.edu.payroll.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void create(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if(optionalEmployee.isPresent()){
            Employee dbEmployee = optionalEmployee.get();
            dbEmployee.setFixedSalary(employee.getFixedSalary());

            repository.save(dbEmployee);
        }
    }

    @Override
    public List<Employee> getEmployeesByEmplType(EmployeeType type) {
        return repository.getEmployeesByEmplType(type);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAllBy();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.getById(id);
    }

}
