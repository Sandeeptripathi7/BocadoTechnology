package com.niit.BocadoBackend.dao;

import com.niit.BocadoBackend.model.Message;
import java.util.List;

public interface MessageDao {
	boolean sendMessage(Message message);
	List<Message> getMyMessages(String emailId);

}
