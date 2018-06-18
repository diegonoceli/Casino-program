/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leonardo Faêda
 */
import DAO.DAOFuncionario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Faêda
 */
public class Funcionario {

    private int codFuncionario;
    private String salarioFuncionaro;
    private String cpfFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;

    /**
     * @param modelo
     * @return the codFuncionario
     */
    public void listar(DefaultTableModel modelo) {
        DAOFuncionario daof = new DAOFuncionario();
        daof.listar(modelo);
    }


    public void pesquisar(DefaultTableModel modelo, String digitado) {
        DAOFuncionario daof = new DAOFuncionario();
        daof.pesquisar(modelo, digitado);
    }

    public void update(Funcionario f) {
        DAOFuncionario daof = new DAOFuncionario();
        daof.update(f);
    }

    public void delete(String id) {
        DAOFuncionario daof = new DAOFuncionario();
        daof.delete(id);
    }

    public void insert(Funcionario f) {
        DAOFuncionario daof = new DAOFuncionario();
        daof.insert(f);
    }

    /**
     * @return the codFuncionario
     */
    public int getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    /**
     * @return the salarioFuncionaro
     */
    public String getSalarioFuncionaro() {
        return salarioFuncionaro;
    }

    /**
     * @param salarioFuncionaro the salarioFuncionaro to set
     */
    public void setSalarioFuncionaro(String salarioFuncionaro) {
        this.salarioFuncionaro = salarioFuncionaro;
    }

    /**
     * @return the cpfFuncionario
     */
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    /**
     * @param cpfFuncionario the cpfFuncionario to set
     */
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the telefoneFuncionario
     */
    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    /**
     * @param telefoneFuncionario the telefoneFuncionario to set
     */
    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

}
