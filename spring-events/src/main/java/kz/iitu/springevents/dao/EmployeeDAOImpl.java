package kz.iitu.springevents.dao;

import kz.iitu.springevents.event.SalaryChangeEvent;
import kz.iitu.springevents.user.Employee;
import kz.iitu.springevents.user.EmployeeType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class EmployeeDAOImpl extends JdbcDaoSupport implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    @PostConstruct
    private void initialize(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/payroll");
        dataSource.setUsername("payroll");
        dataSource.setPassword("123456");
        setDataSource(dataSource);
    }

    public void create(EmployeeType type, int id, String name, String surname, String username, String password, int salary) {
        String typeEmployee = type.toString();
        String myQuery = "INSERT INTO Employee VALUES (?,?,?,?,?,?,?)";
        getJdbcTemplate().update(myQuery, id, name, surname, username, password, salary, typeEmployee);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Employee WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }

    public void changeSalary(int id, int newSalary) {
        String sql = "UPDATE Employee SET salary=? WHERE id=?";
        getJdbcTemplate().update(sql, newSalary, id);

        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, getEmployee(id)));
    }

    public Employee getEmployee(int id) {
        String myQuery = "SELECT * FROM Employee WHERE id=?";
        Employee employee = getJdbcTemplate().queryForObject(myQuery, new Object[]{id}, new EmployeeMapper());
        return employee;
    }

    public List<Employee> listEmployees() {
        String sql = "SELECT * FROM Employee";
        List<Employee> employees = getJdbcTemplate().query(sql, new EmployeeMapper());
        return employees;
    }

    public EmployeeDAOImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
