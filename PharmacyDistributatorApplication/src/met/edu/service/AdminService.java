package met.edu.service;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import met.edu.model.AdminLogin;
import met.edu.model.Customer;
import met.edu.model.Orders;
import met.edu.model.Products;
import met.edu.repository.AdminDAO;

	@Service 
	public class AdminService {
		
		@Autowired
		AdminDAO adminDao;
	

		public Boolean authenticateAdmin(AdminLogin admin){
			
			String password = adminDao.authenticateAdmin(admin);
			
			if(admin.getAdminpass().equals(password))
				return true;
			else
				return false;
			
		}
		
		public java.util.List<Products> getProductDetails(){
			
			return adminDao.getProductDetails();
		}
		
		
		/*public Products getProduct(int id){
			
			return adminDao.getProduct(id);
		}*/
		
		public java.util.List<Customer> getCustomers(){
			
			return adminDao.getCustomers();
		}
	  
		public java.util.List<Orders> getOrders(){
			
			return adminDao.getOrders();
		}
		
		public void updateOrders(Order order){
			 adminDao.updateOrders(order);		
		}
		
}
