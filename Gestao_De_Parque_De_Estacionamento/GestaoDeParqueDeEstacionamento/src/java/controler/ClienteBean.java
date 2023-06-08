/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import models.Cliente;
import controler.ClienteCtr;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Dos SanTos
 */

@ManagedBean

public class ClienteBean{
    
    private ArrayList<Cliente> listaCliente;
    private Cliente cliente;
    
    ClienteCtr cCtr = new ClienteCtr();
    
   @PostConstruct
    public void inicio(){
        listaCliente = new ArrayList<>();
        cliente = new Cliente();
    }

    /**
     * @return the listaCliente
     */
    public ArrayList<Cliente> getListaCliente() {
        return cCtr.recuperarTodosDados();
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    //CRUD
    public void cadastro(){
        
        try {
                this.cCtr.Inserir(cliente);
                limpar();
                addMessage("Saved", "Cliente adicionado Com Sucesso");
        } catch (Exception e) {
            
             addMessage("Error", "Impossivel Salvar o Cliente "+e.getMessage());
            e.printStackTrace();
        }


    }
    
    public void remover(){ 

        try {
                this.cCtr.delete(cliente);
                this.limpar();
                addMessage("Deleted", "Cliente Removido Com Sucesso");
        } catch (Exception e) {
            
             addMessage("Error", "Impossivel Deletar o Cliente "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void update(){   
        try {
                this.cCtr.update(cliente);
                this.limpar();
                addMessage("Updated", "Cliente Actualizado Com Sucesso");
        } catch (Exception e) {
            
             addMessage("Error", "Impossivel Actualizar o Cliente "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void pesquisar(){
        
    }
    
    public void limpar(){
        this.cliente = new Cliente();
    }
    
    public void editar(){}
    
    
    //Confirmacao 

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
