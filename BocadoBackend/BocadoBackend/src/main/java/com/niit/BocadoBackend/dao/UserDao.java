package com.niit.BocadoBackend.dao;

import com.niit.BocadoBackend.model.User;

import java.util.List;

public interface UserDao {
	public boolean save(User user);
	public boolean update(User user);
	public User get(String id);
	public List<User> list();
	public User validate(String id, String password);
}

