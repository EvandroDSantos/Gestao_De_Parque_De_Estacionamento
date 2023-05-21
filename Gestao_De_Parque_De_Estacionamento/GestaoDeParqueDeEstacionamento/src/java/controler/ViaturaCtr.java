/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.Iterator;
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
public class ViaturaCtr {
    public void Inserir(Viatura v){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.saveOrUpdate(v);

            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        
    }
    
    
    public void delete(Viatura v){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.delete(v);

            tr.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }  
    }
    
    
    public void update(Viatura v){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.update(v);

            tr.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }  
    }
    
    public ArrayList <Viatura> recuperarTodosDados(){
     
        ArrayList <Viatura> via = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Viatura viatura;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Viatura");
            it=q.list().iterator();
            while(it.hasNext()){
                Viatura v = new Viatura();
                
                viatura=(Viatura)it.next();
                v.setMatricula(viatura.getMatricula());
                v.setMarca(viatura.getMarca());
                v.setModelo(viatura.getModelo());
                v.setCor(viatura.getCor());
                v.setStatus(viatura.getStatus());
                v.setDataRegisto(viatura.getDataRegisto());
                v.setCliente(viatura.getCliente());
                via.add(v);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return via;
    }
    
    public ArrayList <Viatura> recuperarDadosByName(String nome){
     
        ArrayList <Viatura> via = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Viatura viatura;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Viatura where nrDoc=: name or nome=: name");
            q.setString("name", nome);
            it=q.list().iterator();
            while(it.hasNext()){
                Viatura v = new Viatura();
                
                viatura=(Viatura)it.next();
                v.setMatricula(viatura.getMatricula());
                v.setMarca(viatura.getMarca());
                v.setModelo(viatura.getModelo());
                v.setCor(viatura.getCor());
                v.setStatus(viatura.getStatus());
                v.setDataRegisto(viatura.getDataRegisto());
                v.setCliente(viatura.getCliente());
                via.add(v);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return via;
    }
    
}
