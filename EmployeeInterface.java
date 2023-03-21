package empapp;

public interface EmployeeInterface {

	
	//create employee
	
	public void createEmployee(Employee emp);
	
	//show all employees
	
	public void showAllEmployee();
	
	//show employees based on id
	
	public void showEmployeeBasedOnId(int id);
	
	//update employee
	
	public void updateEmployee(int id,String name);
	
	//delete employee
	
	public void deleteEmployee(int id);


}
