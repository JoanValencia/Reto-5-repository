/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
    private JTextArea resumen_text;
    private JLabel nombre_director;
    private JTextField nombre_director_text;
    private JLabel anio_pelicula;
    private JTextField anio_pelicula_text;
    
    public InputPanel() {
        initComponents();
    }
    
    private void initComponents() {
        
        this.titulo = new JLabel("Ingrese la información solicitada");
        add(titulo);
        
        this.id_pelicula = new JLabel("ID Película");
        add(id_pelicula);
        
        this.id_pelicula_text = new JTextField(20);
        add(id_pelicula_text);
        
        this.nombre_pelicula = new JLabel("Nombre Película");
        add(nombre_pelicula);
        
        this.nombre_pelicula_text = new JTextField(20);
        add(nombre_pelicula_text);
        
        this.resumen = new JLabel("Resumen");
        add(resumen);
        
        this.resumen_text = new JTextArea(5, 20);
        add(resumen_text);
        
        this.nombre_director = new JLabel("Director");
        add(nombre_director);
        
        this.nombre_director_text = new JTextField(20);
        add(nombre_director_text);
        
        this.anio_pelicula = new JLabel("Año Estreno");
        add(anio_pelicula);
        
        this.anio_pelicula_text = new JTextField(20);
        add(anio_pelicula_text);
        
    }
}
