/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridBagLayout;
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
        
        this.label_opciones = new JLabel("Seleccione una de las siguientes opciones:");
        add(label_opciones);
        
        this.consultar_pelicula = new JRadioButton("Consultar peliculas", true);
        add(consultar_pelicula);
        
        this.agregar_pelicula = new JRadioButton("Agregar Pelicula", false);
        add(agregar_pelicula);
        
        this.eliminar_pelicula = new JRadioButton("Eliminar Pelicula", false);
        add(eliminar_pelicula);
        
        this.ejecutar = new JButton("EJECUTAR");
        add(ejecutar);
        
        this.consultas_grupo = new ButtonGroup();
        this.consultas_grupo.add(consultar_pelicula);
        this.consultas_grupo.add(agregar_pelicula);
        this.consultas_grupo.add(eliminar_pelicula);
        
    }
}
