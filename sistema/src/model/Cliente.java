/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAOCliente;
import DAO.DAOFuncionario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Faêda
 */
public class Cliente {
    
    private int codCliente;
    private String cpfCliente;
    private String nomeCliente;
    private String telefoneCliente;
    
    /**
     * @return the codCliente
     */
    public int getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the telefoneCliente
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    /**
     * @param telefoneCliente the telefoneCliente to set
     */
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
     public void salvar(Cliente c){
        DAOCliente daoc = new DAOCliente();
        daoc.salvar(c);
    }
     
     public void listar(DefaultTableModel modelo) {
        DAOCliente daoc = new DAOCliente();
        daoc.listar(modelo);
    }


    public void pesquisar(DefaultTableModel modelo, String digitado) {
        DAOCliente daoc = new DAOCliente();
        daoc.pesquisar(modelo, digitado);
    }

    public void update(Cliente f) {
        DAOCliente daoc = new DAOCliente();
        daoc.update(f);
    }

    public void delete(String id) {
        DAOCliente daoc = new DAOCliente();
        daoc.delete(id);
    }
   
}
