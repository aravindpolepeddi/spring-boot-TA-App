package com.example.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.example.exception.UserException;
import com.example.pojo.Student;
import com.example.pojo.TA;
import com.example.pojo.TACodeReview;

public class CodeReviewDAO extends DAO {
    public CodeReviewDAO() {
    }
    
    public TACodeReview get(int TAID) throws UserException {
   	 try {
           
        	begin();
        	Query q = getSession().createQuery("from TACodeReview where ID= :TAID");
        	q.setParameter("TAID", TAID);
        	TACodeReview cr = (TACodeReview) q.uniqueResult();
        
        	commit();
        	return cr;
        	
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not retrive user ");
        }
   	
   }
    
    public List<TACodeReview> getcrList() throws UserException {
      	 try {
              
           	begin();
           	List q = getSession().createQuery("from TACodeReview").list();

           	List<TACodeReview> crList = q;

           
           	commit();
           	return crList;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user ");
           }
      	
      }
    
    public TACodeReview create(TACodeReview cr) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().persist(cr);
        	commit();
        	close();
        	
        	return cr;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
    
    public TACodeReview update(TACodeReview cr) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().merge(cr);
        	commit();
        	close();
        	
        	return cr;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
    
    public TACodeReview get(int ass_num,int student_id) throws UserException {
        try {
            //save user object in the database
        	begin();
        	Query q = getSession().createQuery("from TACodeReview where (Assignment_num= :ass_num AND student_id=:student_id)");
        	q.setParameter("ass_num", ass_num);
        	q.setParameter("student_id", student_id);
        	TACodeReview TAcr = (TACodeReview) q.uniqueResult();
        
        	commit();
        	
        	return TAcr;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
}
