package com.niit.BocadoBackend.daoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.BocadoBackend.dao.CircleDao;
import com.niit.BocadoBackend.model.Circle;

@Repository(value="circleDao")
public class CircleDaoImpl implements CircleDao {
	@Autowired  
    private SessionFactory sessionFactory; 

	@Override
	public boolean addCircle(Circle circle) {
		  boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().save(circle);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	    }  
	

	@Override
	public boolean deleteCircle(String emailId, String circleName) {
		boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().delete(emailId,circleName);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status; 
	}

	@Override
	public List<Circle> getAllCircles() {
		Session currentSession = sessionFactory.getCurrentSession();  
        Query<Circle> query=currentSession.createQuery("#", Circle.class);  
        List<Circle> list=query.getResultList();  
        return list;  
	}

	@Override
	public List<Circle> getCircleByUser(String emailId) {
		return (List<Circle>) sessionFactory.getCurrentSession().get(Circle.class, emailId);
	}

	@Override
	public Circle getCircleByName(String CircleName) {
		return (Circle) sessionFactory.getCurrentSession().get(Circle.class, CircleName);
	}

}

