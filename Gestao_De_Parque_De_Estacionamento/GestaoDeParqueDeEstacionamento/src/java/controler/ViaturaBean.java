/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Dos SanTos
 */

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Cliente;
import models.Viatura;

@ManagedBean
@ViewScoped
public class ViaturaBean{
    private Viatura viatura;
    private Cliente cliente;
    
    private ArrayList<Viatura> listaViatura;
    private ArrayList<String> PopularCliente;
    
    private ViaturaCtr vCtr = new ViaturaCtr();
    private ClienteCtr cCtr = new ClienteCtr();
    
    @PostConstruct
    public void inicio(){
        setViatura(new Viatura());
        setListaViatura(new ArrayList<>());
        setPopularCliente(new ArrayList<>());
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

    /**
     * @return the viatura
     */
    public Viatura getViatura() {
        return viatura;
    }

    /**
     * @param viatura the viatura to set
     */
    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    /**
     * @return the listaViatura
     */
    public ArrayList<Viatura> getListaViatura() {
        return vCtr.recuperarTodosDados();
    }

    /**
     * @param listaViatura the listaViatura to set
     */
    public void setListaViatura(ArrayList<Viatura> listaViatura) {
        this.listaViatura = listaViatura;
    }


    /**
     * @return the PopularCliente
     */
    public ArrayList<String> getPopularCliente() {
        ArrayList<Cliente> rs = cCtr.recuperarTodosDados();
        for (int i = 0; i < rs.size(); i++) {   
            PopularCliente.add(rs.get(i).getNrDoc());
        }
        return PopularCliente;
    }

    /**
     * @param PopularCliente the PopularCliente to set
     */
    public void setPopularCliente(ArrayList<String> PopularCliente) {
        this.PopularCliente = PopularCliente;
    }    
    
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
        //CRUD
    public void cadastro(){
        //cliente.setNrDoc(viatura.getCliente().getNrDoc());
        
        System.out.println("=============VEJA AQUI A MATRICULA"+viatura.getMatricula());
        
        try {
          
                this.vCtr.Inserir(viatura);
                limpar();
                addMessage("Saved", "viatura adicionado Com Sucesso");
        } catch (Exception e) {
            
             addMessage("Error", "Impossivel Salvar o viatura "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void limpar() {
        this.viatura = new Viatura();
    }
}
