package co.make.it;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateTemplate sessionFactoryTemplate;
	
	public HibernateTemplate getSessionFactoryTemplate() {
		return sessionFactoryTemplate;
	}
	
	@Override
	public void setSessionFactoryTemplate(HibernateTemplate sessionFactoryTemplate) {
		this.sessionFactoryTemplate = sessionFactoryTemplate;
	}
	
	@Override
	public void saveEmployee(Employee e) throws NonUniqueException {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(e);
		} catch (NonUniqueObjectException ex) {
			throw new NonUniqueException(ex.getMessage());
		}
		transaction.commit();
	}
	
	@Override
	public void saveAllEmployee(List<Employee> es) throws NonUniqueException {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (Employee emp : es) {
			try {
				session.save(emp);
			} catch (NonUniqueObjectException ex) {
				throw new NonUniqueException(ex.getMessage());
			}
		}
		transaction.commit();
	}
	
	@Override
	public void saveOrUpdateEmployee(List<Employee> es) {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (Employee emp : es) {
			session.saveOrUpdate(emp);
		}
		transaction.commit();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeNotIn(List<String> empIds) {
		
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.not(Restrictions.in("id", empIds)));
		return criteria.list();
	}
	
	@Override
	public void updateEmployee(Employee e) {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(e);
		transaction.commit();
	}
	
	@Override
	public void deleteEmployee(Employee e) {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(e);
		transaction.commit();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void deleteAllEmployee() {
		
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> delEmps = criteria.list();
		for (Employee emp : delEmps) {
			session.delete(emp);
		}
		transaction.commit();
	}
	
	@Override
	public void queryDatabase(List<Employee> empList) {
		
		List<String> empIds = new ArrayList<>();
		for (Employee employee : empList) {
			empIds.add(employee.getEmployeeCode());
		}
		List<Employee> empNotInList = getEmployeeNotIn(empIds);
		deleteEmployees(empNotInList);
		saveOrUpdateEmployee(empList);
	}
	
	@Override
	public void deleteEmployees(List<Employee> es) {
		Session session = sessionFactoryTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (Employee emp : es) {
			session.delete(emp);
		}
		transaction.commit();
	}
}