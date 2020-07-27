package met.edu.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import met.edu.model.Customer;
import met.edu.model.Products;



@Repository
public class CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveCustomer(Customer customer){
		/*System.out.println(customer.getAddress());*/
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public String authenticateCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String password = (String) session.createCriteria(Customer.class)
		.add(Restrictions.eq("emailid", customer.getEmailid()))
		.setProjection(Projections.property("upass"))
		.uniqueResult();
		
		return password;
		
	}
	
	public java.util.List<Products> getProductDetails(){

		java.util.List<Products> listProducts = jdbcTemplate.query("select * from products", new BeanPropertyRowMapper<>(Products.class));
		return listProducts;
	}
	
	
	
}