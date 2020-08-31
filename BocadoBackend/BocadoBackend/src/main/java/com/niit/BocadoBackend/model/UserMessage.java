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
public class UserMessage implements Serializable {

    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private int messageId;  
    private String messageText;  
    private String senderEmailId;  
    private Date sentDate;
    private long messageSize;
    private long maximumSize;
    private String messageType;
    private String recieverEmailId;
    private String circleName;
    
    public UserMessage() {
    	
    }

	public UserMessage(int messageId, String messageText, String senderEmailId, Date sentDate, long messageSize,
			long maximumSize, String messageType, String recieverEmailId, String circleName) {
		super();
		this.messageId = messageId;
		this.messageText = messageText;
		this.senderEmailId = senderEmailId;
		this.sentDate = sentDate;
		this.messageSize = messageSize;
		this.maximumSize = maximumSize;
		this.messageType = messageType;
		this.recieverEmailId = recieverEmailId;
		this.circleName = circleName;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public long getMessageSize() {
		return messageSize;
	}

	public void setMessageSize(long messageSize) {
		this.messageSize = messageSize;
	}

	public long getMaximumSize() {
		return maximumSize;
	}

	public void setMaximumSize(long maximumSize) {
		this.maximumSize = maximumSize;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getRecieverEmailId() {
		return recieverEmailId;
	}

	public void setRecieverEmailId(String recieverEmailId) {
		this.recieverEmailId = recieverEmailId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
    
}
    

