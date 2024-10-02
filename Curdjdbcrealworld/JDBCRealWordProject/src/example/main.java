package example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

  DAOCustmer daoCustmer=new DAOCustmerImplimention();
  
  Scanner scanner=new Scanner(System.in);
  
  System.out.println("\nCustomer Management System:");
  System.out.println("1: Add Customer");
  System.out.println("2: Get Customer by ID");
  System.out.println("3: Update Customer");
  System.out.println("4: Delete Customer");
  System.out.println("5: Get All Customers");
  System.out.println("6: Exit");
  System.out.print("Choose an option: ");
  
  int choice= scanner.nextInt();
  
  scanner.nextLine();
  
  switch (choice) {
case 1:
	 
	System.out.println("Enter Name:-");
	String name=scanner.nextLine();
	
	System.out.println("Enter Email:-");
	String email=scanner.nextLine();
	
	
	System.out.println("Enter Phone:-");
	String phone=scanner.nextLine();
	
	Customer customer=new Customer(0, name, email, phone);
	
	daoCustmer.addCustomer(customer);
	
	break;

	
case 2:
	
	System.out.println("Enter Id:");
	int id=scanner.nextInt();
	
	Customer retrivecustomer=daoCustmer.getCustomerById(id);
	if(retrivecustomer!=null)
	{
		System.out.println("Customer id" +retrivecustomer.getId()+ ", name"+retrivecustomer.getName()+
				"email" +retrivecustomer.getEmail()+",phone:"+retrivecustomer.getPhone());
		
		
	}
	else
	{
		System.out.println("Customer Not Found");
	}
	
	
case 3:
	    
	 System.out.println("Enter Customer ID:");
	 int updateId=scanner.nextInt();
	 scanner.nextLine();
	 
	 
	 System.out.println("Enter New Name:");
	 String newname=scanner.nextLine();
	 
	 
	 System.out.println("Enter New EmailId");
	 String newemail=scanner.nextLine();
	 
	 
	 System.out.println("Enter New Phone Number:");
	 String newphone=scanner.nextLine();
	 
	 
	 Customer updatecustomer=new Customer(updateId, newname, newemail, newphone);
	 daoCustmer.updateCustomer(updatecustomer);
	 
	 break;
	 
case 4:
	System.out.println("Enter Customer ID to Delete:");
	int deletedid=scanner.nextInt();
	
	
	daoCustmer.deleteCustomer(deletedid);
	
	  break;
	  
case 5:
	
	List<Customer> customers=daoCustmer.getAllCustomer();
	
	for(Customer c: customers)
	{
		System.out.println("ID: " +c.getId()+",name: "+c.getName()+ ",email" +c.getEmail()+ ",phone" +c.getPhone());
	}
	  
	break;
	   
	   
case 6:
	System.out.println("Exit");
	scanner.close();
	return;
default:
	System.out.println("Invalid Options...");
	break;
}
  
  
  
		

	}

}
