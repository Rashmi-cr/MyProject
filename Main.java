package empapp;

import java.io.*;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
	
		
     	
		int id;
		String name;
		Scanner scanner=new Scanner(System.in);
		
		 EmployeeInterface employeeInterface=new EmployeeImpl();
		
		System.out.println("Welcome to Employee management System ");
		System.out.println("**************************************");
		char ch1=' ';
		
		do {
		
			System.out.println("Enter 1 to login ");
			System.out.println("\n1.Admin :");
			//System.out.println("2.Manager :");
		//	System.out.println("3.HR :");
			int c = scanner.nextInt();
		
		switch(c) {
		case 1:
			//String userName="Admin";
		//	 String password="admin123";
			System.out.println("enter user name :");
			String userName1=scanner.next();
			System.out.println("enter password :");
			
			String password1=scanner.next();
			 
			
				if(userName1.equals("Admin")) {
					if(password1.equals("admin123")) {
						System.out.println("login successful");
					}
				
					do {
						System.out.println("\n1.Add employee\n"
								+ "2.Show all employees\n"
								+ "3.Show all employees based on id\n"
								+ "4.Update employee\n"
								+ "5.Delete employee\n"
								+ "6.Exit\n");
						
						
						System.out.println("Enter your choice:");
						int ch=scanner.nextInt();
						
						
						switch(ch){
							
						case 1:
							Employee emp=new Employee();
							
							//System.out.println("Enter id:");
							// id=scanner.nextInt();
							System.out.println("Enter name:");
							
							 name=scanner.next();
						/*	 if(!name.matches("[a-zA-Z]"));
					            {   
					                System.out.println("Please enter a valid name!: ");
					                name=scanner.next();
					                }
					     */
					            
							 
							System.out.println("Enter salary:");
							float salary=scanner.nextFloat();
							System.out.println("Enter age:");
							
							int age=scanner.nextInt();
							//emp.setId(id);
							
							emp.setName(name);
							emp.setSalary(salary);
							if(age>18) {
							emp.setAge(age);
							employeeInterface.createEmployee(emp);
							}else {
								System.out.println("Age not matching with criteria");
							}
					           
							
							
							break; 
							
						case 2:
							employeeInterface.showAllEmployee();
							break;
							
						case 3:
							System.out.println("Enter id to show employee details:");
							int empid=scanner.nextInt();
							
							if(empid!=' ') {
								employeeInterface.showEmployeeBasedOnId(empid);
							}else {
								System.out.println("no such record exist");
							}
							//eid is column in employee table
							break;
							
						case 4:
							System.out.println("Enter id to update employee details:");
							int empid1=scanner.nextInt();
							System.out.println("Enter the new name");
							name=scanner.next();
							employeeInterface.updateEmployee(empid1, name);
							break;
							
						case 5:
							System.out.println("Enter id to delete employee details:");
							id=scanner.nextInt();
							employeeInterface.deleteEmployee(id);
							break;
							
						case 6:
							System.out.println("Thank you");
							System.exit(0);
							
							default:System.out.println("Please enter valid choice !");
							break;
						
						}
					}while(true);
				}
								
				else {
					System.out.println("please enter valid credentials ");
				}
			

			break;
		}
		System.out.println("do you wish to continue say yes");
		
		ch1=scanner.next().charAt(0);
		}while(ch1=='y' || ch1=='Y');

			if(ch1=='N'||ch1=='n') {
				System.out.println("Thank you");
			System.exit(0);
			}
	}
	}
	

