package com.niit.BocadoBackend.model;
import java.io.Serializable;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;
import org.springframework.stereotype.Component;  
  
@Entity  
@Component
public class User implements Serializable {

	
	private static final long serialVersionUID= 1L;
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private int userId;  
    private String emailId;  
    private String password;  
    transient private String cPassword;
    private String name;
    private boolean active;
    private String address;
    private String phoneNo;
    
    public User() {
    	
    }

	public User(int userId, String emailId, String password, String cPassword, String name, boolean active,
			String address, String phoneNo) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.cPassword = cPassword;
		this.name = name;
		this.active = active;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", name=" + name
				+ ", active=" + active + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}

    
}
