package models;
// Generated 14/mai/2023 14:11:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */

public class Cliente  implements java.io.Serializable {
     private String nrDoc;
     private String nome;
     private String apelido;
     private char sexo;
     private String contacto;
     private String email;
     private String status;
     private Set viaturas = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(String nrDoc, String nome, String apelido, char sexo, String contacto, String email, String status) {
        this.nrDoc = nrDoc;
        this.nome = nome;
        this.apelido = apelido;
        this.sexo = sexo;
        this.contacto = contacto;
        this.email = email;
        this.status = status;
    }
    public Cliente(String nrDoc, String nome, String apelido, char sexo, String contacto, String email, String status, Set viaturas) {
       this.nrDoc = nrDoc;
       this.nome = nome;
       this.apelido = apelido;
       this.sexo = sexo;
       this.contacto = contacto;
       this.email = email;
       this.status = status;
       this.viaturas = viaturas;
    }
   
    public String getNrDoc() {
        return this.nrDoc;
    }
    
    public void setNrDoc(String nrDoc) {
        this.nrDoc = nrDoc;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelido() {
        return this.apelido;
    }
    
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public char getSexo() {
        return this.sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Set getViaturas() {
        return this.viaturas;
    }
    
    public void setViaturas(Set viaturas) {
        this.viaturas = viaturas;
    }




}


