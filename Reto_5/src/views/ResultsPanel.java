/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.InitialData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.PeliculaModel;

/**
 *
 * @author gefry
 */
public class ResultsPanel extends JPanel{
    
    private JTable resultados_tabla;
    private JScrollPane resultados_pane;
    private InputPanel inputPanel;
    
    public ResultsPanel(InputPanel inputPanel) {
        this.inputPanel = inputPanel;
        initComponents();
    }
    
    private void initComponents() {
        
        this.resultados_tabla = new JTable();
        this.resultados_tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.resultados_pane = new JScrollPane(this.resultados_tabla);
        add(this.resultados_pane, BorderLayout.CENTER);
    
        resultados_tabla.setPreferredScrollableViewportSize(new Dimension(500, 100));
        
        InitialData initialData = new InitialData();
        this.setTableResults(initialData.getPeliculas());
        
        add(new JScrollPane(this.resultados_tabla));
    }
    
    public void setTableResults(ArrayList<PeliculaModel> peliculas) {
        String[] headers = {"ID", "Resumen", "año", "Título", "Director"};
        this.resultados_tabla.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.resultados_tabla.setModel(tableModel);
        for(int i=0; i < peliculas.size(); i++){
            tableModel.addRow(peliculas.get(i).toArray());
        }
    }
}
