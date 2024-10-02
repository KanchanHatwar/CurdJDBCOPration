package example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCustmerImplimention implements DAOCustmer {

	private Connection connection;
	
	
	
	public DAOCustmerImplimention() throws ClassNotFoundException, SQLException {

   connection=DBConnectivity.getConnection();
	}
	

	@Override
	public void addCustomer(Customer customer) {

String sql="insert into  Customer (name,email,phone) values(?,?,?); ";
		
		try(PreparedStatement pst=connection.prepareStatement(sql)){
			
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getEmail());
			pst.setString(3, customer.getPhone());
			pst.execute();
			System.out.println("Customer Data Addd Successfulyy...");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}

	@Override
	public Customer getCustomerById(int id) {
      String sql="select * from customer where id=?;";
		Customer customer=null;
		try(PreparedStatement pst=connection.prepareStatement(sql)) {
			
			pst.setInt(1, id);
			
		ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				customer=new Customer(rs.getInt(id),rs.getString("name"), rs.getString("email"), rs.getString("phone"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {

		String sql="update  Customer  set name=? ,email=?, phone=? where id=?;";
		
		try (PreparedStatement pst=connection.prepareStatement(sql)){
			
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getEmail());
			pst.setString(3, customer.getPhone());
			pst.setInt(4, customer.getId());
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(int id) {
       
		String sql="Delete from   Customer   where id=?";
		Customer customer=null;
		
		try (PreparedStatement pst=connection.prepareStatement(sql)){
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
			System.out.println("Delete Data..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}

	@Override
	public List<Customer> getAllCustomer() {
     
		List<Customer> cst=new ArrayList<>();
		String Sql="select * from  Customer ;";
		try(Statement st=connection.createStatement()) {
			
			ResultSet rs= st.executeQuery(Sql);
			
			while(rs.next())
			{
				 Customer customer=new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
				 cst.add(customer);
				 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
