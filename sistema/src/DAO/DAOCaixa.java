/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Caixa;

/**
 *
 * @author Pichau
 */
public class DAOCaixa {

    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;

    public void insert(Caixa c) {
        conecta = Conexao.conectar();
        String sql = "INSERT INTO `caixa`(`codCliente`, `data`, `quantidadeFicha`, `valorTotal`, `tipoOperacao`) "
                + "VALUES(?,?,?,?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, c.getCodCliente());
            pst.setString(2, c.getData());
            pst.setString(3, c.getQuantFicha());
            pst.setString(4, String.valueOf(c.getValortotal()));
            pst.setString(5, String.valueOf(c.getTipooperacao()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }

    }

}
