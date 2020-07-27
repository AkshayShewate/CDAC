package met.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminLogin")
public class AdminLogin {
	
	private int adminid;
	private String adminname; 
	private String adminpass;
	
	@Id
	@Column(name="adminid")
	public int getAdminid() {
		return adminid;
	}
	
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	@Column(name="adminname")
	public String getAdminname() {
		return adminname;
	}
	
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	@Column(name="adminpass")
	public String getAdminpass() {
		return adminpass;
	}
	
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	} 
	
	
}
