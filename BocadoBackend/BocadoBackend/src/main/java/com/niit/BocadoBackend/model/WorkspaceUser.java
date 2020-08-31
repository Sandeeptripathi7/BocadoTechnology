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
public class WorkspaceUser implements Serializable {

    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int workspaceUserId;  
    private String companyName;  
    private String userEmailId;  
    private char status;
    
    public WorkspaceUser() {
    	
    }

	public WorkspaceUser(int workspaceUserId, String companyName, String userEmailId, char status) {
		super();
		this.workspaceUserId = workspaceUserId;
		this.companyName = companyName;
		this.userEmailId = userEmailId;
		this.status = status;
	}

	public int getWorkspaceUserId() {
		return workspaceUserId;
	}

	public void setWorkspaceUserId(int workspaceUserId) {
		this.workspaceUserId = workspaceUserId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
    
    
    
}