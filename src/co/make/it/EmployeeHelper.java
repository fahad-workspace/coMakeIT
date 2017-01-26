package co.make.it;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {
	
	private EmployeeHelper() {
		
	}
	
	public static List<Employee> getAddTestData() {
		Employee e1 = new Employee("001", "XXX", "Infrastructure", "8888888888");
		Employee e2 = new Employee("002", "YYY", "Maintenance", "1111111111");
		Employee e4 = new Employee("002", "YYY", "Maintenance", "1111111111");
		Employee e3 = new Employee("003", "ZZZ", "Catering", "2222222222");
		List<Employee> empAddTestData = new ArrayList<>(3);
		empAddTestData.add(e1);
		empAddTestData.add(e2);
		empAddTestData.add(e4);
		empAddTestData.add(e3);
		return empAddTestData;
	}
	
	public static List<Employee> getQueryTestData() {
		Employee e1 = new Employee("001", "XXX", "Infrastructure", "8888888887");
		Employee e4 = new Employee("004", "WWW", "Security", "7777777777");
		Employee e3 = new Employee("003", "ZZZ", "Catering", "9999999999");
		List<Employee> empQueryTestData = new ArrayList<>();
		empQueryTestData.add(e1);
		empQueryTestData.add(e4);
		empQueryTestData.add(e3);
		return empQueryTestData;
	}
}