/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import models.Viatura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dos SanTos
 */
public class ViaturaCtr {
    public void Inserir(Viatura e){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.saveOrUpdate(e);

            tr.commit();
        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }
        
    }
    
    
    public void delete(Viatura e){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.delete(e);

            tr.commit();

        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }  
    }
    
    
    public void update(Viatura e){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.update(e);

            tr.commit();

        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }  
    }
    
}
