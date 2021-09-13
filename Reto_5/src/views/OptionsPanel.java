/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.ClickEvent;
import controller.OnSelectEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;


/**
 *
 * @author gefry
 */
public class OptionsPanel extends JPanel{
    
    private ButtonGroup consultas_grupo;
    private JRadioButton consultar_pelicula;
    private JRadioButton agregar_pelicula;
    private JRadioButton actualizar_pelicula;
    private JRadioButton eliminar_pelicula;
    private JButton ejecutar;
    private final InputPanel input_panel;
    private final ResultsPanel result_panel;
    
    public OptionsPanel(InputPanel inputPanel, ResultsPanel result_panel) {
        this.input_panel = inputPanel;
        this.result_panel = result_panel;
        initComponents();
    }
    
    private void initComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        ClickEvent clickEvent = new ClickEvent(this, this.result_panel, this.input_panel);
        OnSelectEvent onSelectEvent = new OnSelectEvent(this, this.input_panel);
        
        this.consultar_pelicula = new JRadioButton("Consultar Peliculas", true);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(consultar_pelicula, c);
        consultar_pelicula.addActionListener(onSelectEvent);
        
        this.agregar_pelicula = new JRadioButton("Agregar Pelicula", false);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(agregar_pelicula, c);
        agregar_pelicula.addActionListener(onSelectEvent);

        this.actualizar_pelicula = new JRadioButton("Actualizar Pelicula", false);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        add(actualizar_pelicula, c);
        actualizar_pelicula.addActionListener(onSelectEvent);
        
        this.eliminar_pelicula = new JRadioButton("Eliminar Pelicula", false);
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        add(eliminar_pelicula, c);
        eliminar_pelicula.addActionListener(onSelectEvent);

        this.ejecutar = new JButton("EJECUTAR");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        add(ejecutar, c);
        this.ejecutar.addActionListener(clickEvent);
        
        this.consultas_grupo = new ButtonGroup();
        this.consultas_grupo.add(consultar_pelicula);
        this.consultas_grupo.add(agregar_pelicula);
        this.consultas_grupo.add(actualizar_pelicula);
        this.consultas_grupo.add(eliminar_pelicula);
        
    }
    
    public String getTextActiveOption(ButtonGroup buttonGroup) {
        //TODO revisar mejores formas de traer la opción activa
        for (Enumeration<AbstractButton> botonesOpciones = buttonGroup.getElements(); botonesOpciones.hasMoreElements();) {
            AbstractButton button = botonesOpciones.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    public ButtonGroup getButtonGroup(){
        return this.consultas_grupo;
    }
}
