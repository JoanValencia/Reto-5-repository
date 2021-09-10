/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author gefry
 */
public class InputPanel extends JPanel {
    
    private JLabel titulo;
    private JLabel id_pelicula;
    private JTextField id_pelicula_text;
    private JLabel nombre_pelicula;
    private JTextField nombre_pelicula_text;
    private JLabel resumen;
    private JTextField resumen_text;
    private JLabel nombre_director;
    private JTextField nombre_director_text;
    private JLabel apellido_director;
    private JTextField apellido_director_text;
    private JLabel anio_pelicula;
    private JTextField anio_pelicula_text;
    
    public InputPanel() {
        initComponents();
    }
    
    private void initComponents() {
        
        this.titulo = new JLabel("Ingrese la información solicitada");
        add(titulo);
        
        
    }
}
