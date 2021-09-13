/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.InputPanel;
import views.OptionsPanel;

/**
 *
 * @author gefry
 */
public class OnSelectEvent implements ActionListener {

    private OptionsPanel optionsPanel;
    private InputPanel inputPanel;
    
    public OnSelectEvent (OptionsPanel optionsPanel, InputPanel inputPanel) {
        this.optionsPanel = optionsPanel;
        this.inputPanel = inputPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String option = this.optionsPanel.getTextActiveOption(this.optionsPanel.getButtonGroup());
        System.out.println(option);
        
        switch(option){
        case "Consultar Peliculas":
            System.out.println("Deshabilitar campos de no consulta");
            this.inputPanel.enableFields(false);
            this.inputPanel.getNombrePeliculaText().setEnabled(true);
            this.inputPanel.getNombrePelicula().setEnabled(true);
            break;
            
        case "Agregar Pelicula":
            System.out.println("Habilitar todos los campos");
            this.inputPanel.enableFields(true);
            this.inputPanel.getIdPeliculaText().setEnabled(false);
            this.inputPanel.getIdPelicula().setEnabled(false);
            break;
            
        case "Actualizar Pelicula":
            System.out.println("Habilitar todos los campos");
            this.inputPanel.enableFields(true);
            break;
            
        case "Eliminar Pelicula":
            System.out.println("Eliminar una pelicula por algunos campos");
            this.inputPanel.enableFields(false);
            this.inputPanel.getIdPeliculaText().setEnabled(true);
            this.inputPanel.getIdPelicula().setEnabled(true);
            break;
            
        default:
            System.out.println("Opción no válida");
            break;
        }
    }
    
}
