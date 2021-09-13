/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DirectorDAO;
import access.PeliculaDAO;
import java.util.ArrayList;
import model.DirectorModel;
import model.PeliculaModel;

/**
 *
 * @author gefry
 */
public class InitialData { 
    
    private ArrayList<PeliculaModel> peliculas = null;
    private ArrayList<DirectorModel> directores = null;
    
    public InitialData() {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        this.peliculas = peliculaDAO.getAllMovies();
        
        DirectorDAO directorDAO = new DirectorDAO();
        this.directores = directorDAO.getAllDirectoresList();     
    }
    
    public ArrayList<PeliculaModel> getPeliculas() {
        return peliculas;
    }
    
    public ArrayList<DirectorModel> getDirectores() {
        return directores;
    }
}
