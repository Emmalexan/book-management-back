package gr.hua.dit.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.User;

import javax.annotation.Resource;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@SuppressWarnings("deprecation")
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }
      
	public boolean checkLogin(String userName, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			
		//	String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			
			String SQL_QUERY =" from User where userName=?0 and userPassword=?1";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			System.out.println(userName + userPassword );
			
			
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
				
			}

			session.close();
			return userFound;              
       }
}
