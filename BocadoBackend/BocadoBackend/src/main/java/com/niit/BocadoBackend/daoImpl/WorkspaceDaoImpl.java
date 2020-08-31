package com.niit.BocadoBackend.daoImpl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.BocadoBackend.dao.WorkspaceDao;
import com.niit.BocadoBackend.model.Workspace;

@Repository(value="workspaceDao")
@Component
@Transactional

public class WorkspaceDaoImpl implements WorkspaceDao{
	 @Autowired  
	    private SessionFactory sessionFactory;  

	@Override
	public boolean createWorkspace(Workspace workspace) {
		 boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().save(workspace);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	}

	@Override
	public List<Workspace> getWorkspaceByAdminEmailId(String emailId) {
		return (List<Workspace>) sessionFactory.getCurrentSession().get(Workspace.class, emailId);
	}

}

