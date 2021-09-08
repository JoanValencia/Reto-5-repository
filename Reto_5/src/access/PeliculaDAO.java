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
import model.PeliculaModel;
import utils.ConnectionDB;



public class PeliculaDAO {
    private Connection conn = null;
    
    public ArrayList<PeliculaModel> obtenerPeliculas(){
        ArrayList<PeliculaModel> peliculas = new ArrayList<PeliculaModel>();
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT pelicula.pel_id as ID, "
                    + "contenidos.cont_titulo AS Titulo, "
                    + "pelicula.pel_resumen AS Resumen, "
                    + "CONCAT(director.dir_nombre,CONCAT(' ', director.dir_apellido)) AS Director, "
                    + "pelicula.pel_anio AS Año "
                    + "FROM pelicula JOIN contenidos ON pelicula.cont_id = contenidos.cont_id "
                    + "JOIN director ON pelicula.dir_id = director.dir_id "
                    + "ORDER BY pelicula.pel_id;";
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
                    ex.printStackTrace();}
        return peliculas;
    }
    
    public void agregarPelicula(PeliculaModel pelicula){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO pelicula(cont_id, dir_id, pel_resumen, pel_anio)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getContId_fk());
            statement.setInt(2, pelicula.getDirId_fk());
            statement.setString(3, pelicula.getPelResumen());
            statement.setInt(4, pelicula.getPelAnio());
            int rowsInserted = statement.executeUpdate();
            
            //Condicional para validar el funcionamiento:
            if (rowsInserted > 0)
                System.out.println("Se insertó");
            else
                System.out.println("No funcionó");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void actualizarPelicula (PeliculaModel pelicula){
       /* try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO pelicula(cont_id, dir_id, pel_resumen, pel_anio)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getContId_fk());
            statement.setInt(2, pelicula.getDirId_fk());
            statement.setString(3, pelicula.getPelResumen());
            statement.setInt(4, pelicula.getPelAnio());
            int rowsInserted = statement.executeUpdate();

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }*/
    }
    
    public void eliminarPelicula(int pelId){
        /* try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO pelicula(cont_id, dir_id, pel_resumen, pel_anio)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getContId_fk());
            statement.setInt(2, pelicula.getDirId_fk());
            statement.setString(3, pelicula.getPelResumen());
            statement.setInt(4, pelicula.getPelAnio());
            int rowsInserted = statement.executeUpdate();

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }*/
    }
    public static void main(String[] args) {
        ArrayList<PeliculaModel> prueba = new ArrayList<PeliculaModel>();
        
        //prueba = obtenerPeliculas();
    }
}
