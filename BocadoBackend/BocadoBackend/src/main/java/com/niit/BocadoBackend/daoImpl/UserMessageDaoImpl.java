package com.niit.BocadoBackend.daoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;  
import com.niit.BocadoBackend.dao.UserMessageDao;
import com.niit.BocadoBackend.model.Message;
import com.niit.BocadoBackend.model.User;
import com.niit.BocadoBackend.model.UserMessage;

@Repository("usermessageDao")
public class UserMessageDaoImpl implements UserMessageDao {
	 @Autowired  
	    private SessionFactory sessionFactory;  

	@Override
	public boolean sendMessage(UserMessage usermessage) {
		boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().save(usermessage);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status; 
	}

	@Override
	public boolean deleteMessage(int messageId) {
		boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().delete(messageId);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status; 
	}

	@Override
	public List<UserMessage> getMyMessages(String emailId) {
		 Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query <UserMessage> query = session.createQuery("from Message");  
	            List<UserMessage> list = query.list();  
	              
	            if(list.size() > 0)  
	            {  
	                return list;  
	            }  
	            else  
	            {  
	                return null;  
	            }  
	              
	        }  
	        catch(Exception exception)  
	        {  
	            System.out.println("Excecption while saving  Details : " + exception.getMessage());  
	            return null;  
	        }  
	        finally  
	        {  
	            session.flush();  
	        }  
	}

	@Override
	public List<UserMessage> getAllMessageByCircleName(String circleName) {
		return (List<UserMessage>) sessionFactory.getCurrentSession().get(UserMessage.class, circleName);
	}

	@Override
	public boolean isRecieverExists(String recieverEmailId) {
		Session session = null;
		session = sessionFactory.getCurrentSession(); 
		 Query query = session.createQuery("#");
		 query.setParameter("#", recieverEmailId);
	
	        if (!query.list().isEmpty()) {
	            return false;
	        }
	        return true;
	}

	@Override
	public boolean isCircleExists(String circleName) {
		Session session = null;
		session = sessionFactory.getCurrentSession(); 
		 Query query = session.createQuery("#");
		 query.setParameter("#", circleName);
	
	        if (!query.list().isEmpty()) {
	            return false;
	        }
	        return true;
	}

	@Override
	public List<UserMessage> getAllMessageByUser(String senderEmailId, String receiverEmailId) {
		return (List<UserMessage>) sessionFactory.getCurrentSession().get(senderEmailId,receiverEmailId);
	}

}

