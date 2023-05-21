/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.Iterator;
import models.Pagamento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dos SanTos
 */
public class PagamentoCtr {
    public void Inserir(Pagamento p){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr = null;
        
        try {
            tr = sessao.beginTransaction();
            sessao.saveOrUpdate(p);

            tr.commit();
        } catch (Exception el) {
            el.printStackTrace();
            tr.rollback();
        }
        
    }
    
    public ArrayList <Pagamento> recuperarTodosDados(){
     
        ArrayList <Pagamento> pag = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Pagamento pagamento;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Pagamento");
            it=q.list().iterator();
            while(it.hasNext()){
                Pagamento p = new Pagamento();
                pagamento=(Pagamento)it.next();
                
                p.setIdPag(pagamento.getIdPag());
                p.setDataPag(pagamento.getDataPag());
                p.setViatura(pagamento.getViatura());
                p.setNrDocCliente(pagamento.getNrDocCliente());
                p.setNomeCliente(pagamento.getNomeCliente());
                p.setDiasParq(pagamento.getDiasParq());
                
                pag.add(p);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return pag;
    }
    
    public ArrayList <Pagamento> recuperarByName(String name){
     
        ArrayList <Pagamento> pag = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session sessao = sessionFactory.openSession();
        Transaction tr=null;
        Iterator it;
        Pagamento pagamento;
        try{
            tr=sessao.beginTransaction();
            Query q=sessao.createQuery("from Pagamento where nrMatricula=: name");
            q.setString("name", name);
            it=q.list().iterator();
            while(it.hasNext()){
                Pagamento p = new Pagamento();
                pagamento=(Pagamento)it.next();
                
                p.setIdPag(pagamento.getIdPag());
                p.setDataPag(pagamento.getDataPag());
                p.setViatura(pagamento.getViatura());
                p.setNrDocCliente(pagamento.getNrDocCliente());
                p.setNomeCliente(pagamento.getNomeCliente());
                p.setDiasParq(pagamento.getDiasParq());
                
                pag.add(p);
            
            }
            tr.commit();
        
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    
    
    return pag;
    }
    
}
