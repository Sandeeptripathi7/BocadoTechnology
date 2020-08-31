package com.niit.BocadoBackend.daoImpl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository; 
import org.hibernate.query.Query;
import com.niit.BocadoBackend.dao.MessageDao;
import com.niit.BocadoBackend.dao.UserDao;
import com.niit.BocadoBackend.model.Message;
import com.niit.BocadoBackend.model.User;

@Repository(value="messageDao")
@Component
@Transactional

public class MessageDaoImpl implements MessageDao {
	@Autowired  
    private SessionFactory sessionFactory;  
	
	public boolean sendMessage(Message message) {
		try {
			sessionFactory.getCurrentSession().save(message);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}

	@Override
	public List<Message> getMyMessages(String emailId) {
		
		return (List<Message>) sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("senderEmailId", emailId)) ;
	}
	

}
