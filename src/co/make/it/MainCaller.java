package co.make.it;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCaller {
	
	private MainCaller() {
		
	}
	
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
			dao.deleteAllEmployee();
			// Use Case 2
			try {
				dao.saveAllEmployee(EmployeeHelper.getAddTestData());
			} catch (NonUniqueException e) {
				
				System.out.println(e.getMessage());
			}
			// Use Case 1
			dao.queryDatabase(EmployeeHelper.getQueryTestData());
		}
	}
}