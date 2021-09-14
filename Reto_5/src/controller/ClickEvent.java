/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.ContenidoDAO;
import access.PeliculaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ContenidoModel;
import model.DirectorModel;
import model.PeliculaModel;
import views.InputPanel;
import views.ResultsPanel;
import views.OptionsPanel;

/**
 *
 * @author gefry
 */
public class ClickEvent implements ActionListener {

    private OptionsPanel optionsPanel;
    private ResultsPanel resultPanel;
    private InputPanel inputPanel;
    
    public ClickEvent (OptionsPanel optionsPanel, ResultsPanel resultPanel, InputPanel inputPanel) {
        this.optionsPanel = optionsPanel;
        this.resultPanel = resultPanel;
        this.inputPanel = inputPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {        
        
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<PeliculaModel> peliculas = new ArrayList<>();
        String option = this.optionsPanel.getTextActiveOption(this.optionsPanel.getButtonGroup());
        
        System.out.println("from button");
        System.out.println(option);
        switch(option){
        case "Consultar Peliculas":
            System.out.println("Consultar las peliculas");
            ArrayList<PeliculaModel> resultado_peliculas = new ArrayList<>();
            resultado_peliculas = peliculaDAO.getMovie(this.inputPanel.getNombrePeliculaText().getText());
            this.resultPanel.setTableResults(resultado_peliculas);
            break;
            
        case "Agregar Pelicula":
            System.out.println("Agregar una pelicula");
            try {
                int pel_id = 0; // La tabla crea el ID de forma automática
                int cont_id = this.getContenidoId(this.inputPanel.getNombrePeliculaText().getText());
                int dir_id = ((DirectorModel)this.inputPanel.getNombreDirectorText().getSelectedItem()).getDir_id();
                String pel_resumen = this.inputPanel.getResumenPeliculaText().getText();
                int pel_anio = Integer.parseInt(this.inputPanel.getAnioPeliculaText().getText()); 
                PeliculaModel pelicula = new PeliculaModel(pel_id, cont_id, dir_id, pel_resumen, pel_anio);
                peliculaDAO.agregarPelicula(pelicula);         
                peliculas = peliculaDAO.getAllMovies();
                this.resultPanel.setTableResults(peliculas);
                this.inputPanel.getIdPeliculaText().setText("");
                this.inputPanel.getNombrePeliculaText().setText("");
                this.inputPanel.getResumenPeliculaText().setText("");
                this.inputPanel.getAnioPeliculaText().setText("");
                String mensaje = "Se agregó pelicula correctamente.";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Agregar Pelicula",
                JOptionPane.INFORMATION_MESSAGE);
            }
            catch (NumberFormatException ex) {
                String mensaje = "No se pudo agregar la pelicula, revise que la información esté completa.";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Agregar Pelicula",
                JOptionPane.INFORMATION_MESSAGE);
            }
            break;
            
        case "Actualizar Pelicula":
            System.out.println("Actualizar Pelicula");
            try {
                int pel_id = Integer.parseInt(this.inputPanel.getIdPeliculaText().getText());
                int cont_id = this.getContenidoIdByPelId(pel_id);
                int dir_id = ((DirectorModel)this.inputPanel.getNombreDirectorText().getSelectedItem()).getDir_id();
                String cont_titulo = this.inputPanel.getNombrePeliculaText().getText();
                int pel_anio = 0;
                String pel_resumen = "";
                if(!this.inputPanel.getResumenPeliculaText().getText().equals("")){
                    pel_resumen = this.inputPanel.getResumenPeliculaText().getText();
                }
                if(!this.inputPanel.getAnioPeliculaText().getText().equals("")){
                    pel_anio = Integer.parseInt(this.inputPanel.getAnioPeliculaText().getText());
                }
                PeliculaModel pelicula = new PeliculaModel(pel_id, cont_id, dir_id, cont_titulo, pel_resumen, pel_anio);
                peliculaDAO.actualizarPelicula(pelicula);
                peliculas = peliculaDAO.getAllMovies();
                this.resultPanel.setTableResults(peliculas);
                this.inputPanel.getIdPeliculaText().setText("");
                this.inputPanel.getNombrePeliculaText().setText("");
                this.inputPanel.getResumenPeliculaText().setText("");
                this.inputPanel.getAnioPeliculaText().setText("");
            }
            catch (NumberFormatException ex) {
                String mensaje = "No se pudo agregar la pelicula, revise que la información esté completa.";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Agregar Pelicula",
                JOptionPane.INFORMATION_MESSAGE);
            }
            break;
            
        case "Eliminar Pelicula":
            System.out.println("Eliminar una pelicula");
            //TODO eliminar también en la tabla de contenidos
            peliculaDAO.eliminarPelicula(this.inputPanel.getIdPeliculaText().getText());
            peliculas = peliculaDAO.getAllMovies();
            this.resultPanel.setTableResults(peliculas);
            this.inputPanel.getIdPeliculaText().setText("");
            break;
            
        default:
            System.out.println("Seleccione una opción...");
            break;
        }
    }

    public int getContenidoId(String Titulo) {
        
        ContenidoModel contenido = new ContenidoModel(0, Titulo);
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        contenidoDAO.insertContenido(contenido);
        return contenidoDAO.getIdByTitulo(Titulo);
    }
    
    public int getContenidoIdByPelId(int pel_id) {
        
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        return contenidoDAO.getContIdByPelId(pel_id);
    }
}
