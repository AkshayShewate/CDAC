package met.edu.controller;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import met.edu.model.AdminLogin;
import met.edu.model.Customer;
import met.edu.model.Orders;
import met.edu.model.Products;
import met.edu.service.AdminService;
import met.edu.service.CustomerService;


@Controller
public class PharmacyController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;
	
	

/*	@RequestMapping(value= "/hello" ,method=RequestMethod.GET)
	public ModelAndView getMessage(){
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", "Welcome To Pharmacy Project");
		return modelAndView;
	}
	
	@RequestMapping(value= "/hello" ,method=RequestMethod.POST)
	public ModelAndView getMessage1(){
		ModelAndView modelAndView = new ModelAndView("sucess");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value= "/sucess" ,method=RequestMethod.GET)
	public ModelAndView showMessage(){
		ModelAndView modelAndView = new ModelAndView("sucess");
		modelAndView.addObject("message", "Welcome To Pharmacy Project");
		return modelAndView;
	}*/
	
	/*@RequestMapping(value= "/index" ,method=RequestMethod.GET)
	public String getMessage(ModelMap model){
		CustomerDetail customer = new CustomerDetail();
		model.addAttribute("CustomerDetail", customer);
		return "index";
	}*/
	
	@RequestMapping(value= "/index" ,method=RequestMethod.GET)
	public String getIndex(){
		return "index";
	}
	
	
	
	
	@RequestMapping(value= "/adminlogin" ,method=RequestMethod.GET)
	public String getAdmin(ModelMap model){
		
		AdminLogin admin = new AdminLogin();
		model.addAttribute("adminlogin",admin);
		return "adminlogin";
	}
	
	@RequestMapping(value= "/adminlogin" ,method=RequestMethod.POST)
	public String postAdmin(@ModelAttribute AdminLogin admin, ModelMap model){
		
		Boolean result = adminService.authenticateAdmin(admin);
		
		if(result)
			return "redirect:admin_panel";
		else
			return "redrect:adminlogin";
	}
	
	
	
	
	
	@RequestMapping(value= "/customerlogin" ,method=RequestMethod.GET)
	public String getCustomer(ModelMap model){
		
		Customer c = new Customer();
		model.addAttribute("customer",c);
		return "customerlogin";
	}
	
	@RequestMapping(value= "/customerlogin" ,method=RequestMethod.POST)
	public String postCustomer(@ModelAttribute Customer c, ModelMap model){
		
		Boolean result = customerService.authenticateCustomer(c);
		if(result)
			return "redirect:cust_panel";
		else{
			model.addAttribute("error", "Invalid Emailid or Password");
			return "redirect:customerlogin";
		}
	}
	
	
	
	
	
	@RequestMapping(value= "/registration_form" ,method=RequestMethod.GET)
	public String getRegForm(ModelMap model){
		Customer c = new Customer();
		
		model.addAttribute("customer", c);
		return "registration_form";
	}
	
	@RequestMapping(value= "/registration_form" ,method=RequestMethod.POST)
	public String postRegForm(@ModelAttribute Customer c) {
	
		customerService.saveCustomer(c);
		return "redirect:customerlogin";
	}
	
	
	
	@RequestMapping(value= "/sucess" ,method=RequestMethod.GET)
	public String getSucess(ModelMap model){
		Orders order = new Orders();
		
		model.addAttribute("order", order);
		return "sucess";
	}
	
	@RequestMapping(value= "/sucess" ,method=RequestMethod.POST)
	public String postSucess(@ModelAttribute Order o) {
	
		adminService.updateOrders(o);
		return "redirect:sucess";
	}
	
	
	
	@RequestMapping(value= "/admin_panel" ,method=RequestMethod.GET)
	public ModelAndView getAdminPanel(){
		
		ModelAndView mav = new ModelAndView("admin_panel");
		Products products = new Products();
		mav.addObject("productDetails", products);
		java.util.List<Products> allProducts = adminService.getProductDetails(); 
		mav.addObject("productList", allProducts);
		System.out.println(products.getPid());
		return mav;
	}
	
	/*@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public ModelAndView getProducts(@PathVariable int id){
		
		Products product = adminService.getProduct(id);
		ModelAndView modelAndView = new ModelAndView("admin_panel");
		
		modelAndView.addObject("productList", product);
		
		return modelAndView;
		
	}*/
	
	
	
	@RequestMapping(value= "/sales" ,method=RequestMethod.GET)
	public ModelAndView getSales(){
		
		ModelAndView mav = new ModelAndView("sales");
		Orders order = new Orders();
		mav.addObject("orderDetails", order);
		java.util.List<Orders> allOrders = adminService.getOrders(); 
		mav.addObject("orderList", allOrders);
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value= "/catalog" ,method=RequestMethod.GET)
	public String getCatalog(){
		return "catalog";
	}
	
	@RequestMapping(value= "/cust_details" ,method=RequestMethod.GET)
	public ModelAndView getCustDetails(){
		
		ModelAndView mav = new ModelAndView("cust_details");
		Customer customer = new Customer();
		mav.addObject("customerDetails", customer);
		java.util.List<Customer> allCustomers = adminService.getCustomers(); 
		mav.addObject("customerList", allCustomers);
		return mav;
	}
	
	@RequestMapping(value= "/promo" ,method=RequestMethod.GET)
	public String getPromo(){
		return "promo";
	}
	
	@RequestMapping(value= "/report" ,method=RequestMethod.GET)
	public String getReport(){
		return "report";
	}
	
	
	
	
	@RequestMapping(value= "/cust_panel" ,method=RequestMethod.GET)
	public ModelAndView getCustPanel(){

		ModelAndView mav = new ModelAndView("cust_panel");
		Products products = new Products();
		mav.addObject("productDetails", products);
		java.util.List<Products> allProducts = customerService.getProductDetails(); 
		mav.addObject("productList", allProducts);
		
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value= "/my_orders" ,method=RequestMethod.GET)
	public String getMyOrders(){
		return "my_orders";
	}
	
	@RequestMapping(value= "/offers" ,method=RequestMethod.GET)
	public String getMyOffers(){
		return "offers";
	}
	
	@RequestMapping(value= "/my_account" ,method=RequestMethod.GET)
	public String getMyAccount(){
		return "my_account";
	}
	
	@RequestMapping(value= "/cart" ,method=RequestMethod.GET)
	public String getCart(){
		return "cart";
	}
}


