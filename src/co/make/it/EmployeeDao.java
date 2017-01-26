package co.make.it;

import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;

interface EmployeeDao {
	
	void setSessionFactoryTemplate(HibernateTemplate sessionFactoryTemplate);
	
	public void saveEmployee(Employee e) throws NonUniqueException;
	
	void saveAllEmployee(List<Employee> es) throws NonUniqueException;
	
	void saveOrUpdateEmployee(List<Employee> es);
	
	List<Employee> getEmployeeNotIn(List<String> empIds);
	
	void updateEmployee(Employee e);
	
	void deleteEmployee(Employee e);
	
	void deleteEmployees(List<Employee> es);
	
	void deleteAllEmployee();
	
	public void queryDatabase(List<Employee> empList);
}