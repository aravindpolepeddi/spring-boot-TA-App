package com.example.dao;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.example.exception.UserException;
import com.example.pojo.User;

public class AJAXDAO extends DAO {
	
    public AJAXDAO() {
    }

    public User get(String username) throws UserException {
   	 try {
           
        	begin();
        	Query q = getSession().createQuery("from User where name= :username");
        	q.setParameter("username", username);
        	User user = (User) q.uniqueResult();
        
        	commit();
        	return user;
        	
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not create user " + username, e);
        }
   	
   }
}
