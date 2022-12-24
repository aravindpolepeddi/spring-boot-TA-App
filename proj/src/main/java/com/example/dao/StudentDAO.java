package com.example.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.example.exception.UserException;
import com.example.pojo.Student;
import com.example.pojo.TA;

public class StudentDAO extends DAO{
	
    public StudentDAO() {
    }
    
    public Student get(int UserID) throws UserException {
   	 try {
           
        	begin();
        	Query q = getSession().createQuery("from Student where User_ID= :UserID");
        	q.setParameter("UserID", UserID);
        	Student student = (Student) q.uniqueResult();
        
        	commit();
        	return student;
        	
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not retrive user " + UserID, e);
        }
   	
   }
    
    public Student getfromstudentid(int ID) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("from Student where ID= :ID");
           	q.setParameter("ID", ID);
           	Student student = (Student) q.uniqueResult();
           
           	commit();
           	return student;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " , e);
           }
      	
      }
    
    public int getTAID(int UserID) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("Select ta_id from Student where User_ID= :UserID");
           	q.setParameter("UserID", UserID);
           	int ta_id = (int) q.uniqueResult();
           
           	commit();
           	return ta_id;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + UserID, e);
           }
      	
      }
    
    public List<Student> getStudentList() throws UserException {
      	 try {
              
           	begin();
           	List q = getSession().createQuery("from Student").list();
           	List<Student> studentList = q;
           
           	commit();
           	return studentList;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive studentList");
           }
      	
      }
    
    public List<Student> getStudentList(int TA_ID) throws UserException {
     	 try {
             
          	begin();
          	Query q = getSession().createQuery("from Student where ta_id= :TA_ID");
          	q.setParameter("TA_ID", TA_ID);
          	List<Student> studentList = q.list();
          
          	commit();
          	return studentList;
          	
          } catch (HibernateException e) {
              rollback();
              throw new UserException("Could not retrive studentList");
          }
     	
     }
    
    public Student create(Student student) throws UserException {
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
    
    public Student update(Student student) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().merge(student);
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
