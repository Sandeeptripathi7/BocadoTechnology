package com.niit.BocadoBackend.dao;

import com.niit.BocadoBackend.dao.List;
import com.niit.BocadoBackend.dao.String;

public interface UserCircleDao {
	boolean addUserToCircle(String emailId, String circleName);
	boolean deleteUserfromCircle(String emailId, String circleName);
	List <String> getUsersofCircle(String circleName);
	

}

