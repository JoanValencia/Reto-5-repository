/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author gefry
 */
public class InputPanel extends JPanel {
    
    private JPanel principal;
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
        
        setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        
        this.id_pelicula = new JLabel("ID Película");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(this.id_pelicula, c);
        
        this.id_pelicula_text = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        add(this.id_pelicula_text, c);
        
        this.nombre_pelicula = new JLabel("Nombre Película");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(this.nombre_pelicula, c);
        
        this.nombre_pelicula_text = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        add(this.nombre_pelicula_text, c);
        
        this.resumen = new JLabel("Resumen");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        add(this.resumen, c);
        
        this.resumen_text = new JTextArea(3, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 3;
        add(this.resumen_text, c);
        
        this.nombre_director = new JLabel("Director");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        add(this.nombre_director, c);
        
        this.nombre_director_text = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        add(nombre_director_text, c);
        
        this.anio_pelicula = new JLabel("Año Estreno");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        add(anio_pelicula, c);
        
        this.anio_pelicula_text = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        add(anio_pelicula_text, c);

    }
}
