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
import model.Acesso;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOAcesso {

    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;
    Acesso acesso;

    public DAOAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public boolean verificaLogin(String login, String senha) {
        String sql = "SELECT `tipoAcesso` FROM `acesso` WHERE `login`=? AND `senha`=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            if (rs.next()) {
                acesso.setTipo(Integer.valueOf(rs.getString("tipoAcesso")));
                return true;
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return false;
    }

}
