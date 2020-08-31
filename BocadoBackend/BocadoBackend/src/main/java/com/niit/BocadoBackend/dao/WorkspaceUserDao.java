package com.niit.BocadoBackend.dao;

import com.niit.BocadoBackend.dao.String;

public interface WorkspaceUserDao {
	boolean sendInvitation(String companyName, String userEmailId);
	boolean acceptInvitation(String companyName, String userEmailId);
	boolean rejectInvitation(String companyName, String userEmailId);
	boolean removeUserFromWorkspace(String companyName, String userEmailId);

}
