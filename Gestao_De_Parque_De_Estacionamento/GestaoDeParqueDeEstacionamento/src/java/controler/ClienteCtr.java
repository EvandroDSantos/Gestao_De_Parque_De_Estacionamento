/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.Iterator;
import models.Cliente;
import models.Viatura;
import org.hibernate.Query;
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
    
    public ArrayList <Cliente> recuperarTodosDados(){
     
        ArrayList <Cliente> cli = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Cliente cliente;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Cliente");
            it=q.list().iterator();
            while(it.hasNext()){
                Cliente c = new Cliente();
                cliente=(Cliente)it.next();
                c.setNrDoc(cliente.getNrDoc());
                c.setNome(cliente.getNome());
                c.setApelido(cliente.getApelido());
                c.setSexo(cliente.getSexo());
                c.setContacto(cliente.getContacto());
                c.setEmail(cliente.getEmail());
                c.setStatus(cliente.getStatus());
                
                cli.add(c);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return cli;
    }
    
    public ArrayList <Cliente> recuperarDadosByName(String nome){
     
        ArrayList <Cliente> cli = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Cliente cliente;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Cliente where nrDoc=: name");
            q.setString("name", nome);
            it=q.list().iterator();
            while(it.hasNext()){
                Cliente c = new Cliente();
                cliente=(Cliente)it.next();
                c.setNrDoc(cliente.getNrDoc());
                c.setNome(cliente.getNome());
                c.setApelido(cliente.getApelido());
                c.setSexo(cliente.getSexo());
                c.setContacto(cliente.getContacto());
                c.setEmail(cliente.getEmail());
                c.setStatus(cliente.getStatus());
                
                cli.add(c);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return cli;
    }
}
