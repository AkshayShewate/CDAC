package met.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import met.edu.model.Customer;
import met.edu.model.Products;
import met.edu.repository.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDao;
	
	public void saveCustomer(Customer customer){
		 customerDao.saveCustomer(customer);		
	}
	
	public Boolean authenticateCustomer(Customer customer) {
		
		String password = customerDao.authenticateCustomer(customer);
		if(customer.getUpass().equals(password))	
			return true;
		return false;
	}
	
	public java.util.List<Products> getProductDetails(){
		
		return customerDao.getProductDetails();
	}
}