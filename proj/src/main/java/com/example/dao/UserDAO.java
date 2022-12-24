package com.example.dao;

import com.example.exception.*;
import com.example.pojo.User;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

public class UserDAO extends DAO {

    public UserDAO() {
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
    public User create(User user) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().persist(user);
        	commit();
        	close();
        	
        	return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user) throws UserException {
    	 try {
             //save user object in the database
         	begin();
         	getSession().delete(user);
         	commit();
         	
         } catch (HibernateException e) {
             rollback();
             //throw new AdException("Could not create user " + username, e);
             throw new UserException("Exception while deleting user: " + e.getMessage());
         }
    }
    
    public User LoginCheck(String username, String password) throws UserException{
   	 try {
         //save user object in the database
     	begin();
     	Query q = getSession().getNamedQuery("checklogin");
     	q.setParameter("username",username);
     	q.setParameter("password",password);
     	commit();
     	return (User) q.uniqueResult();
     	
     } catch (HibernateException e) {
         rollback();
         //throw new AdException("Could not create user " + username, e);
         throw new UserException("Exception while deleting user: " + e.getMessage());
     }
    }
}