package com.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.example.exception.UserException;
import com.example.pojo.Admin;
import com.example.pojo.Student;
import com.example.pojo.TA;
import com.example.pojo.User;

public class AdminDAO extends DAO {

	public  AdminDAO() {
    }
	
    public Admin get(int UserID) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("from Admin where UserID= :UserID");
           	q.setParameter("UserID", UserID);
           	Admin admin = (Admin) q.uniqueResult();
           
           	commit();
           	return admin;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + UserID, e);
           }
      	
      }
    
    public User createUser(User user) throws UserException {
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
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
    
    public Student createStudent(Student student) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().persist(student);
        	commit();
        	close();
        	
        	return student;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
    

}
