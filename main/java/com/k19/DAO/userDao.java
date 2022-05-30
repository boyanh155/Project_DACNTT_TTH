package com.k19.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.dbUtil;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.k19.models.Users;
public class userDao {
    public void saveUser(Users user) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        try {
            emf = dbUtil.getEMF();
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.persist(user);
            trans.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
            trans.rollback();
        } catch (NullPointerException e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Users selectUser(String gmail) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();

        String query="SELECT u from Users u " + "WHERE u.gmail = :gmail";
        TypedQuery<Users> q = em.createQuery(query, Users.class);
        q.setParameter("gmail", gmail);
        Users user=null;
        try {
            user = q.getSingleResult();
            
        }catch(NoResultException e){
            e.printStackTrace();
            return null;
        }
         finally {
            if (em != null) {
                em.close();
            }
        }
        return user;
    }
    public static Users selectUserById(int _id){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        Users User = null;
        try {
            User = em.find(Users.class, _id);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return User;
    }
    public void updateUser(Users user) {
        //
        // EntityManagerFactory emf = null;
        // EntityManager em = null;
        // make entity manager
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        try {
            emf = Persistence.createEntityManagerFactory("k19WebApp");
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        // users user=UserDAO.selectUserById(id);
        // user.setFirstName(firstName);
        // user.setLastName(lastName);
        // user.setEmail(email);
        // user.setGentle(gentle);
        // user.setContact(contact);
        // doInJPA(em -> {
        //     LOGGER.info("Merging the Post entity");
        //     users _user = entityManager.merge(user);});
        // String query="SELECT u from users u " + "WHERE u.email = :email";
        // TypedQuery<users> q = em.createQuery(query, users.class);
        // q.setParameter("email", email);
        // users user=null;
        // try {
        //     user = q.getSingleResult();
            
        // }catch(NoResultException e){
        //     e.printStackTrace();
        //     return null;
        // }
        //  finally {
        //     if (em != null) {
        //         em.close();
        //     }
        // }
        
    }
    public static Users checkUser(final String gmail, final String password){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        // query
        String query = "SELECT u from Users u " + "WHERE u.gmail = :gmail and u.passWord = :password";
        // retrieve
        TypedQuery<Users> q = em.createQuery(query, Users.class);
        q.setParameter("gmail", gmail);
        q.setParameter("password", password);
        Users user = null;
        try {
            user = q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();

            }
        }
        return user;
    }
}
