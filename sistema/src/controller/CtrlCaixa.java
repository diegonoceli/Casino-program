/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import model.Caixa;

/**
 *
 * @author Pichau
 */
public class CtrlCaixa {

    public void insert(ArrayList<String> registro) {
        Caixa caixa = new Caixa();
        caixa.setCodCliente(registro.get(0));
        caixa.setQuantFicha(registro.get(1));
        caixa.setValortotal(Integer.valueOf(registro.get(2)));
        caixa.setTipooperacao(Integer.valueOf(registro.get(3)));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        caixa.setData(localDate.toString());
        caixa.insert(caixa);

    }

}
