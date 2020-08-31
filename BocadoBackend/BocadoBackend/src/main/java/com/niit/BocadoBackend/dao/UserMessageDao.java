package com.niit.BocadoBackend.dao;

import java.util.List;

import com.niit.BocadoBackend.model.UserMessage;


public interface UserMessageDao {
	boolean sendMessage(UserMessage usermessage);
	boolean deleteMessage(int messageId);
	List<UserMessage> getMyMessages(String emailId);
	List<UserMessage> getAllMessageByCircleName(String circleName);
	boolean isRecieverExists(String recieverEmailId);
	public boolean isCircleExists(String circleName);
	List<UserMessage> getAllMessageByUser(String senderEmailId, String receiverEmailId);
	
 
}
