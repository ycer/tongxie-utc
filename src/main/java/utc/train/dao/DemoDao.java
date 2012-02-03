package utc.train.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import utc.train.pojo.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Bill
 * @version 2012-02-03
 */
@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate template;

    public boolean test() {
        return template == null;
    }

    public void saveEmployee(Employee employee) {
         //template.update("insert into employee()");
    }

    public List<Employee> findEmployee(String surname) {
        return template.query("select * from employee where surname = ?", new Object[]{surname}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setSurname(rs.getString("surname"));
                employee.setGivenName(rs.getString("givenname"));
                employee.setSsn(rs.getString("ssn"));
                employee.setCentury(rs.getString("century"));
                return employee;
            }
        });
    }

}
