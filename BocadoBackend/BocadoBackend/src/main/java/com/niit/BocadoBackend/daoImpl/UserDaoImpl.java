package com.niit.BocadoBackend.daoImpl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository; 
import org.hibernate.query.Query;  
 import com.niit.BocadoBackend.dao.UserDao;
import com.niit.BocadoBackend.model.User;

@Repository(value="userDao")
@Component
@Transactional

public class UserDaoImpl implements UserDao {
	 @Autowired  
	    SessionFactory sessionFactory;
	 
	 @Autowired
	 User user;
	 
	 public UserDaoImpl(SessionFactory sessionFactory) {
		 super();
		 this.sessionFactory=sessionFactory;
	 }
	 
	 public boolean save(User user) {
		 boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().save(user);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	 }
	 
	 public boolean update(User user) {
		 boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().update(user);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	 }
	 
	 public User get(String id) {
		 user=(User) sessionFactory.getCurrentSession().get(User.class, id);
		 return user;
	 }
	 
	 public List<User> list(){
		 Session session = null;  
	        try  
	        {  
	            session = sessionFactory.getCurrentSession();  
	              
	            Query <User> query = session.createQuery("from User");  
	            List<User> list = query.list();  
	              
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
		

	 
	 public User validate(String id, String password) {
		 String hql="from User where emailId= '"+ id + "'and password= '"+password +"'";
		 Query query= sessionFactory.openSession().createQuery(hql);
		 return (User) query.uniqueResult();
	 }
	 

}

