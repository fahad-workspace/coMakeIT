package co.make.it;

public class Employee {
	
	private String employeeCode;
	private String employeeName;
	private String departmentName;
	private String phoneNumber;
	
	public Employee() {
		
		// Needed for DI
	}
	
	public Employee(String employeeCode, String employeeName, String departmentName, String phoneNumber) {
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}