package com.example.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.example.exception.UserException;
import com.example.pojo.Student;
import com.example.pojo.TA;

public class TADAO extends DAO {
	
    public TADAO() {
    }
    
    public TA get(int UserID) throws UserException {
   	 try {
           
        	begin();
        	Query q = getSession().createQuery("from TA where UserID= :UserID");
        	q.setParameter("UserID", UserID);
        	TA TA = (TA) q.uniqueResult();
        
        	commit();
        	return TA;
        	
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not retrive user " + UserID, e);
        }
   	
   }
    
    public Date getcodereviewstart(Date codereviewdate) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("Select codereviewstart from TA where codereviewdate= :codereviewdate");
           	q.setParameter("codereviewdate", codereviewdate);
           	Date codereviewstart = (Date) q.uniqueResult();
           
           	commit();
           	return codereviewstart;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + e);
           }
      	
      }
    
    public int getcodereviewperiod(Date codereviewdate) throws UserException {
     	 try {
             
          	begin();
          	Query q = getSession().createQuery("Select codereviewperiod from TA where codereviewdate= :codereviewdate");
          	q.setParameter("codereviewdate", codereviewdate);
          	int codereviewperiod = (int) q.uniqueResult();
          
          	commit();
          	return codereviewperiod;
          	
          } catch (HibernateException e) {
              rollback();
              throw new UserException("Could not retrive user " + e);
          }
     	
     }
    
    public int getTAUserID(int TAID) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("Select UserID from TA where ID= :TAID");
           	q.setParameter("TAID", TAID);
           	int TAUserID = (int)q.uniqueResult();
           
           	commit();
           	return TAUserID;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + e);
           }
      	
      }
    
    public int getTAID(Date codereviewdate) throws UserException {
     	 try {
             
          	begin();
          	Query q = getSession().createQuery("Select ID from TA where codereviewdate= :codereviewdate");
          	q.setParameter("codereviewdate", codereviewdate);
          	int TAID = (int)q.uniqueResult();
          
          	commit();
          	return TAID;
          	
          } catch (HibernateException e) {
              rollback();
              throw new UserException("Could not retrive user " + e);
          }
     	
     }
    
    public Date getstartTime(Date codereviewdate) throws UserException {
    	 try {
            
         	begin();
         	Query q = getSession().createQuery("Select codereviewstart from TA where codereviewdate= :codereviewdate");
         	q.setParameter("codereviewdate", codereviewdate);
         	Date startTime = (Date)q.uniqueResult();
         
         	commit();
         	return startTime;
         	
         } catch (HibernateException e) {
             rollback();
             throw new UserException("Could not retrive user " + e);
         }
    	
    }
    
    public Date getendTime(Date codereviewdate) throws UserException {
   	 try {
           
        	begin();
        	Query q = getSession().createQuery("Select codereviewend from TA where codereviewdate= :codereviewdate");
        	q.setParameter("codereviewdate", codereviewdate);
        	Date endTime = (Date)q.uniqueResult();
        
        	commit();
        	return endTime;
        	
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not retrive user " + e);
        }
   	
   }
    
    public int getTimePeriod(Date codereviewdate) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("Select codereviewperiod from TA where codereviewdate= :codereviewdate");
           	q.setParameter("codereviewdate", codereviewdate);
           	int period = (int)q.uniqueResult();
           
           	commit();
           	return period;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + e);
           }
      	
      }
    
    public List<Integer> getAssnum(int UserID) throws UserException {
     	 try {
             
          	begin();
          	Query q = getSession().createQuery("Select assignment_num from TA where UserID= :UserID");
          	q.setParameter("UserID", UserID);
          	List<Integer> tassnum = q.list();
          
          	commit();
          	return tassnum;
          	
          } catch (HibernateException e) {
              rollback();
              throw new UserException("Could not retrive user " + e);
          }
     	
     }
    
    public List<TA> getTA(int TAID) throws UserException {
      	 try {
              
           	begin();
           	Query q = getSession().createQuery("from TA where UserID= :TAID");
           	q.setParameter("TAID", TAID);
           	List<TA> taList = q.list();
           
           	commit();
           	return taList;
           	
           } catch (HibernateException e) {
               rollback();
               throw new UserException("Could not retrive user " + TAID, e);
           }
      	
      }
    
    public List<Date> getTACRDates(int assignment_num) throws UserException {
     	 try {
             
          	begin();
          	Query q = getSession().createQuery("Select codereviewdate from TA where assignment_num= :assignment_num");
          	q.setParameter("assignment_num", assignment_num);
          	List<Date> taList = q.list();
          
          	commit();
          	return taList;
          	
          } catch (HibernateException e) {
              rollback();
              throw new UserException("Could not retrive user " + e);
          }
     	
     }
    
    
    public List<TA> getTAList() throws UserException {
    	 try {
            
         	begin();
         	List q = getSession().createQuery("from TA").list();
         	List<TA> taList = q;
         
         	commit();
         	return taList;
         	
         } catch (HibernateException e) {
             rollback();
             throw new UserException("Could not retrive studentList");
         }
    	
    }
    
    public TA create(TA ta) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().persist(ta);
        	commit();
        	close();
        	
        	return ta;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }
    
    public TA update(TA ta) throws UserException {
        try {
            //save user object in the database
        	begin();
        	getSession().merge(ta);
        	commit();
        	close();
        	
        	return ta;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new UserException("Exception while creating TA: " + e.getMessage());
        }
    }

}
