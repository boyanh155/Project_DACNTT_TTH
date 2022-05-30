package com.k19.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.dbUtil;
import com.k19.controller.signUpConfirm;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.k19.models.Register;
public class RegisterDao {
    public void saveUser(Register user) {
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
    public static Register selectUser(String gmail) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();

        String query="SELECT u from Register u " + "WHERE u.gmail = :gmail";
        TypedQuery<Register> q = em.createQuery(query, Register.class);
        q.setParameter("gmail", gmail);
        Register user=null;
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
    public static Register selectUserById(int _id){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        Register User = null;
        try {
            User = em.find(Register.class, _id);
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
    public void updateUser(Register user) {
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
    
    public static Register checkUser(final String email, final String password){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        // query
        String query = "SELECT u from Register u " + "WHERE u.email = :email and u.password = :password";
        // retrieve
        TypedQuery<Register> q = em.createQuery(query, Register.class);
        q.setParameter("email", email);
        q.setParameter("password", password);
        Register user = null;
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
    public void DeleteRegister(Register User){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        try {
            emf = dbUtil.getEMF();
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.remove(User);
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
}
