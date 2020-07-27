package met.edu.repository;


import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;


import met.edu.model.AdminLogin;
import met.edu.model.Customer;
import met.edu.model.Orders;
import met.edu.model.Products;

@Repository
public class AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public String authenticateAdmin(AdminLogin admin){
		
		org.hibernate.Session session = sessionFactory.getCurrentSession();
	
		String password = (String)  session.createCriteria(AdminLogin.class)
				.add(Restrictions.eq("adminid", admin.getAdminid()))
				.setProjection(Projections.property("adminpass"))
				.uniqueResult();
				
				return password;
	}
	

	public java.util.List<Products> getProductDetails(){

		java.util.List<Products> listProducts = jdbcTemplate.query("select * from products", new BeanPropertyRowMapper<>(Products.class));
		return listProducts;
	}
	
	
	/*public Products getProduct(int id){
		String sql = "select * from products where pid=?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{id},
				new BeanPropertyRowMapper<>(Products.class));
	}*/
	
	public java.util.List<Customer> getCustomers(){
	
		java.util.List<Customer> listCustomers =jdbcTemplate.query("select * from customers", new BeanPropertyRowMapper<>(Customer.class));
		return listCustomers;
				
	}
	
	public java.util.List<Orders> getOrders(){
		
		java.util.List<Orders> listOrders =jdbcTemplate.query("select * from orders", new BeanPropertyRowMapper<>(Orders.class));
		return listOrders;
				
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateOrders(Order order){
		
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
}
