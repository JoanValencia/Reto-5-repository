/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ContenidoModel;
import model.PeliculaModel;
import utils.ConnectionDB;



public class PeliculaDAO {
    
    private Connection conn = null;
    
    public ArrayList<PeliculaModel> getAllMovies(){
        ArrayList<PeliculaModel> peliculas = new ArrayList<>();
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT peliculas.pel_id as ID, "
                    + "contenidos.cont_titulo AS Titulo, "
                    + "peliculas.pel_resumen AS Resumen, "
                    + "CONCAT(director.dir_nombre,CONCAT(' ', director.dir_apellido)) AS Director, "
                    + "peliculas.pel_anio AS Año "
                    + "FROM peliculas JOIN contenidos ON peliculas.cont_id = contenidos.cont_id "
                    + "JOIN director ON peliculas.dir_id = director.dir_id "
                    + "ORDER BY peliculas.pel_id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                PeliculaModel pelicula = new PeliculaModel(result.getInt(1), 
                        result.getString(2),result.getString(3), 
                        result.getString(4),result.getInt(5));
                peliculas.add(pelicula);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return peliculas;
    }
    
    public ArrayList<PeliculaModel> getMovie(String titulo){
        ArrayList<PeliculaModel> peliculas = new ArrayList<>();
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT peliculas.pel_id as ID, "
                    + "contenidos.cont_titulo AS Titulo, "
                    + "peliculas.pel_resumen AS Resumen, "
                    + "CONCAT(director.dir_nombre,CONCAT(' ', director.dir_apellido)) AS Director, "
                    + "peliculas.pel_anio AS Año "
                    + "FROM peliculas JOIN contenidos ON peliculas.cont_id = contenidos.cont_id "
                    + "JOIN director ON peliculas.dir_id = director.dir_id "
                    + "WHERE contenidos.cont_titulo LIKE '%" + titulo + "%' "
                    + "ORDER BY peliculas.pel_id;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                PeliculaModel pelicula = new PeliculaModel(result.getInt(1), 
                        result.getString(2),result.getString(3), 
                        result.getString(4),result.getInt(5));
                peliculas.add(pelicula);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        String mensaje = "Resultados obtenidos: " + peliculas.size();
        JOptionPane.showMessageDialog(new JFrame(), mensaje, "Consulta de películas",
        JOptionPane.INFORMATION_MESSAGE);
        return peliculas;
    }
    
    public void agregarPelicula(PeliculaModel pelicula){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO peliculas(cont_id, dir_id, pel_resumen, pel_anio)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getContId_fk());
            statement.setInt(2, pelicula.getDirId_fk());
            statement.setString(3, pelicula.getPelResumen());
            statement.setInt(4, pelicula.getPelAnio());
            int rowsInserted = statement.executeUpdate();
            
            //Condicional para validar el funcionamiento:
            if (rowsInserted > 0)
                System.out.println("Se insertaron " + rowsInserted + " registros.");
            else
                System.out.println("No se insertó ningún registro.");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void actualizarPelicula (PeliculaModel pelicula){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE peliculas SET ";
            if(pelicula.getPelAnio() != 0){
                sql = sql + "pel_anio = " + pelicula.getPelAnio() ;
            }
            if(!pelicula.getPelResumen().equals("")){
                if(pelicula.getPelAnio() != 0){
                    sql = sql + ", pel_resumen = " + "'" + pelicula.getPelResumen() + "'"; 
                }
                else {
                    sql = sql + " pel_resumen = " + "'" + pelicula.getPelResumen() + "'";
                }
            }
            if(!pelicula.getContTitulo().equals("")){
                ContenidoDAO contenidoDAO = new ContenidoDAO();
                contenidoDAO.updatecontenidoById(new ContenidoModel(pelicula.getContId_fk(), pelicula.getContTitulo()));   
            }
            if (pelicula.getPelAnio() != 0 || !pelicula.getPelResumen().equals("")){
                sql = sql + ", dir_id = " + pelicula.getDirId_fk();  
            }
            else {
                sql = sql + " dir_id = " + pelicula.getDirId_fk(); 
            }
            
            sql = sql + " WHERE pel_id = " + pelicula.getPelId();
            
            PreparedStatement statement = conn.prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                String mensaje = "Pelicula actualizada con éxito!";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Actualizar Película",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                String mensaje = "No se pudo actualizar la pelicula, revise que la información"
                        + "ingresada sea correcta.";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Actualizar Película",
                JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void eliminarPelicula(String pelId){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM peliculas"
                    + " WHERE pel_id = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pelId);
            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                String mensaje = "Pelicula Borrada con éxito!";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Borrar Película",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                String mensaje = "No se pudo borrar la pelicula, revise el Id ingresado.";
                JOptionPane.showMessageDialog(new JFrame(), mensaje, "Borrar Película",
                JOptionPane.ERROR_MESSAGE);          
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
