package com.niit.BocadoBackend.dao;

import java.util.List;

import com.niit.BocadoBackend.model.Workspace;

public interface WorkspaceDao {
       boolean createWorkspace(Workspace workspace); 
       List<Workspace> getWorkspaceByAdminEmailId (String emailId);
       
}
