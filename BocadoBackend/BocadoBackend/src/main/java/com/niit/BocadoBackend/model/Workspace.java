package com.niit.BocadoBackend.model;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;
import org.springframework.stereotype.Component;  
  
@Entity  
@Component
public class Workspace implements Serializable {

    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private int workspaceId;  
    private String purpose;  
    private String typeOfOrganisation;  
    private int teamSize;
    private String role;
    private String companyName;
    private String adminEmailId;
    private Date creationDate;
    
    public Workspace() {
    	
    }
    
	public Workspace(int workspaceId, String purpose, String typeOfOrganisation, int teamSize, String role,
			String companyName, String adminEmailId, Date creationDate) {
		super();
		this.workspaceId = workspaceId;
		this.purpose = purpose;
		this.typeOfOrganisation = typeOfOrganisation;
		this.teamSize = teamSize;
		this.role = role;
		this.companyName = companyName;
		this.adminEmailId = adminEmailId;
		this.creationDate = creationDate;
	}
	public int getWorkspaceId() {
		return workspaceId;
	}
	public void setWorkspaceId(int workspaceId) {
		this.workspaceId = workspaceId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getTypeOfOrganisation() {
		return typeOfOrganisation;
	}
	public void setTypeOfOrganisation(String typeOfOrganisation) {
		this.typeOfOrganisation = typeOfOrganisation;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
    
    
}

