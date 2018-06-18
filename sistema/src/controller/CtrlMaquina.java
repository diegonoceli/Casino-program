/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template mile, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Maquina;

/**
 *
 * @author Leonardo Faêda
 */
public class CtrlMaquina {

   
    private ArrayList<Maquina> arrayMaquina = new ArrayList();
    public void listar(DefaultTableModel modelo) {
        Maquina m = new Maquina();
        m.listar(modelo);
    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        Maquina m = new Maquina();
        m.pesquisar(modelo, digitado);
    }

    public void update(ArrayList<String> registro) {
        Maquina m = new Maquina();

        m.setNomeMaquina(registro.get(0));
        m.setStatusMaquina(registro.get(1));
        m.setCodMaquina(Integer.valueOf(registro.get(2)));
        m.update(m);
    }

    public void delete(String id) {
        Maquina m = new Maquina();
        m.delete(id);
    }

    public void insert(ArrayList<String> registro) {
        Maquina m = new Maquina();
        m.setNomeMaquina(registro.get(0));
        m.setStatusMaquina(registro.get(1));

        m.insert(m);
    }
    
     public void gerarRelatorio () throws FileNotFoundException, IOException{
        
        PdfWriter writer = null;
        PdfDocument pdf = null;
        Document document = null;
        writer = new PdfWriter("relatorioAlunos.pdf");
        pdf = new PdfDocument(writer);
        document = new Document(pdf);
        document.setMargins(20, 20, 20, 20);
        Paragraph cabecalho = new Paragraph("Lista de Máquinas Inoperantes");
        document.add(cabecalho);
        
        Maquina m = new Maquina();
        m.gerarRelatorio(this.arrayMaquina);
        
        Table table = new Table(2);
        table.addCell(new Cell().add(new Paragraph("Código")));
        table.addCell(new Cell().add(new Paragraph("Nome")));
        if(getArrayMaquina().size() == 0){
            System.out.println("Não a cadastro para imprimir");
        }else{
            for(int i=0; i<getArrayMaquina().size(); i++){
               table.addCell(new Cell().add(new Paragraph(String.valueOf(getArrayMaquina().get(i).getCodMaquina()))));
               table.addCell(new Cell().add(new Paragraph(getArrayMaquina().get(i).getNomeMaquina())));
            }
        }
        
        document.add(table);
        Desktop.getDesktop().open(new File("relatorioAlunos.pdf"));
        
        document.close();
        
        
        
        
        
    }

 /**
     * @return the arrayMaquina
     */
    public ArrayList<Maquina> getArrayMaquina() {
        return arrayMaquina;
    }

    /**
     * @param arrayMaquina the arrayMaquina to set
     */
    public void setArrayMaquina(ArrayList<Maquina> arrayMaquina) {
        this.arrayMaquina = arrayMaquina;
    }
}
