package example;

import java.util.List;

public interface DAOCustmer {

	
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);
	
	List<Customer> getAllCustomer();
}
