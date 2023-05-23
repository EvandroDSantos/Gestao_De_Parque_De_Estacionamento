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
    
    
    public void cadastro(){ 
        cCtr.Inserir(cliente);
        cliente = new Cliente();
    }
}
