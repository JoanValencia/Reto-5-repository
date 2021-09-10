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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;


/**
 *
 * @author gefry
 */
public class OptionsPanel extends JPanel{
    
    private ButtonGroup consultas_grupo;
    private JLabel label_opciones;
    private JRadioButton consultar_pelicula;
    private JRadioButton agregar_pelicula;
    private JRadioButton eliminar_pelicula;  
    private JButton ejecutar;
    
    public OptionsPanel() {
        initComponents();
    }
    
    private void initComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        this.consultar_pelicula = new JRadioButton("Consultar peliculas", true);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(consultar_pelicula, c);
        
        this.agregar_pelicula = new JRadioButton("Agregar Pelicula", false);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(agregar_pelicula, c);
        
        this.eliminar_pelicula = new JRadioButton("Eliminar Pelicula", false);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        add(eliminar_pelicula, c);
        
        this.ejecutar = new JButton("EJECUTAR");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        add(ejecutar, c);
        
        this.consultas_grupo = new ButtonGroup();
        this.consultas_grupo.add(consultar_pelicula);
        this.consultas_grupo.add(agregar_pelicula);
        this.consultas_grupo.add(eliminar_pelicula);
        
    }
}
