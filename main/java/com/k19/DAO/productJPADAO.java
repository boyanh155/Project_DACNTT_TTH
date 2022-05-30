package com.k19.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.k19.models.product;

import connection.dbUtil;

public class productJPADAO {

    // insert
    public void insertProduct(final product product) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        try {
            emf = dbUtil.getEMF();
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.persist(product);
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
    // select single
    public static product selectProduct(final String productCode) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        product product = null;
        try {
            product = em.find(product.class, productCode);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return product;
    }
    //  select 
    public static List<product> selectProducts(String classify,String sort) {
        EntityManager em = dbUtil.getEMF().createEntityManager();
        String qString = "SELECT u from product u ";
        if(classify!=null)
        {
            qString+="WHERE u.classify = :classify ";
        }
        if(sort!=null)
        {
            qString+="ORDER BY u.price "+sort;
        }
        if(classify==null)
        {
            TypedQuery<product> q = em.createQuery(qString, product.class);
            List<product> products;
            try {
                products = q.getResultList();
                if (products == null || products.isEmpty())
                    products = null;
            } finally {
                em.close();
            }
            return products;
        }
        else{
            TypedQuery<product> q = em.createQuery(qString, product.class);
            q.setParameter("classify", classify);
            List<product> products;
            try {
                products = q.getResultList();
                if (products == null || products.isEmpty())
                    products = null;
            } finally {
                em.close();
            }
            return products;
        }
    }
}