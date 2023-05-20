/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import models.Cliente;
import models.Viatura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dos SanTos
 */
public class ClienteCtr {
    public void Inserir(Cliente c){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.saveOrUpdate(c);

            tr.commit();
        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }
        
    }
    
    
    public void delete(Cliente c){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.delete(c);

            tr.commit();

        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }  
    }
    
    
    public void update(Cliente c){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.update(c);

            tr.commit();

        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }  
    }
}
