/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAOCliente;
import DAO.DAOLogin;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Faêda
 */
public class Login {
    private int codLogin;
    private String nomeLogin;
    private String Login;
    private String SenhaLogin;
    private String nivel;
    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    
    /**
     * @return the codLogin
     */
    public int getCodLogin() {
        return codLogin;
    }

    /**
     * @param codLogin the codLogin to set
     */
    public void setCodLogin(int codLogin) {
        this.codLogin = codLogin;
    }

    /**
     * @return the nomeLogin
     */
    public String getNomeLogin() {
        return nomeLogin;
    }

    /**
     * @param nomeLogin the nomeLogin to set
     */
    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the SenhaLogin
     */
    public String getSenhaLogin() {
        return SenhaLogin;
    }

    /**
     * @param SenhaLogin the SenhaLogin to set
     */
    public void setSenhaLogin(String SenhaLogin) {
        this.SenhaLogin = SenhaLogin;
    }
    
     public void salvar(Login c){
        DAOLogin daoc = new DAOLogin();
        daoc.salvar(c);
    }
     
     public void listar(DefaultTableModel modelo) {
        DAOLogin daoc = new DAOLogin();
        daoc.listar(modelo);
    }


    public void pesquisar(DefaultTableModel modelo, String digitado) {
        DAOLogin daoc = new DAOLogin();
        daoc.pesquisar(modelo, digitado);
    }

    public void update(Login f) {
        DAOLogin daoc = new DAOLogin();
        daoc.update(f);
    }

    public void delete(String id) {
        DAOLogin daoc = new DAOLogin();
        daoc.delete(id);
    }

    
}
