/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.DAOCaixa;

/**
 *
 * @author Pichau
 */
public class Caixa {
    private String codCliente;
    private String data;
    private String quantFicha;
    private int valortotal;
    private int tipooperacao;

    /**
     * @return the codCliente
     */
    public String getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the quantFicha
     */
    public String getQuantFicha() {
        return quantFicha;
    }

    /**
     * @param quantFicha the quantFicha to set
     */
    public void setQuantFicha(String quantFicha) {
        this.quantFicha = quantFicha;
    }

    /**
     * @return the valortotal
     */
    public int getValortotal() {
        return valortotal;
    }

    /**
     * @param valortotal the valortotal to set
     */
    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    /**
     * @return the tipooperacao
     */
    public int getTipooperacao() {
        return tipooperacao;
    }

    /**
     * @param tipooperacao the tipooperacao to set
     */
    public void setTipooperacao(int tipooperacao) {
        this.tipooperacao = tipooperacao;
    }

    public void insert(Caixa caixa) {
        DAOCaixa dao=new DAOCaixa();
        dao.insert(caixa);
    }
    
}
