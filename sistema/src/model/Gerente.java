/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import DAO.DAOGerente;
import DAO.DAOGerente;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Leonardo Faêda
 */
public class Gerente {

    /**
     * @return the salarioGerente
     */
    public String getSalarioGerente() {
        return salarioGerente;
    }

    /**
     * @param salarioGerente the salarioGerente to set
     */
    public void setSalarioGerente(String salarioGerente) {
        this.salarioGerente = salarioGerente;
    }
    
    private int codGerente;
    private String salarioGerente;
    private String cpfGerente;
    private String nomeGerente;
    private String telefoneGerente;
  
    
    public Gerente(){
        this.codGerente = -1;
        this.cpfGerente = "";
        this.nomeGerente = "";
        this.telefoneGerente = ""; 
    }
    
    public int getCodGerente() {
        return codGerente;
    }

    /**
     * @param codGerente the codGerente to set
     */
    public void setCodGerente(int codGerente) {
        this.codGerente = codGerente;
    }

    /**
     * @return the cpfGerente
     */
    public String getCpfGerente() {
        return cpfGerente;
    }

    /**
     * @param cpfGerente the cpfGerente to set
     */
    public void setCpfGerente(String cpfGerente) {
        this.cpfGerente = cpfGerente;
    }

    /**
     * @return the nomeGerente
     */
    public String getNomeGerente() {
        return nomeGerente;
    }

    /**
     * @param nomeGerente the nomeGerente to set
     */
    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    /**
     * @return the telefoneGerente
     */
    public String getTelefoneGerente() {
        return telefoneGerente;
    }

    /**
     * @param telefoneGerente the telefoneGerente to set
     */
    public void setTelefoneGerente(String telefoneGerente) {
        this.telefoneGerente = telefoneGerente;
    }
    
    public void salvar(){
        DAOGerente daof = new DAOGerente();
        daof.salvar(this);
    }
    
     public void listar(DefaultTableModel modelo) {
        DAOGerente daof = new DAOGerente();
        daof.listar(modelo);
    }


    public void pesquisar(DefaultTableModel modelo, String digitado) {
        DAOGerente daof = new DAOGerente();
        daof.pesquisar(modelo, digitado);
    }

    public void update(Gerente f) {
        DAOGerente daof = new DAOGerente();
        daof.update(f);
    }

    public void delete(String id) {
        DAOGerente daof = new DAOGerente();
        daof.delete(id);
    }

   

 
}
