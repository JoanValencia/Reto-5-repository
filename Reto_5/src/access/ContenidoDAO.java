/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ContenidoModel;
import model.DirectorModel;
import utils.ConnectionDB;

/**
 *
 * @author gefry
 */
public class ContenidoDAO {
    private Connection conn = null;
    
    public ArrayList<ContenidoModel> insertContenido(ContenidoModel contenidoModel){
        ArrayList<ContenidoModel> contenido = new ArrayList<>();
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO contenidos (cont_id, cont_titulo)"
                    + "VALUES (?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, contenidoModel.getCont_id());
            statement.setString(2, contenidoModel.getCont_titulo());
            int rowsInserted = statement.executeUpdate();
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return contenido;
    }
    
    
    public int getIdByTitulo(String cont_titulo){
        int id = 0;
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT cont_id FROM contenidos "
                    + "WHERE cont_titulo = '"
                    + cont_titulo +"';";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                //si llegan a existir dos contenidos con el mismo nombre
                //traerá el último id
                id = result.getInt(1);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return id;
    }
    
    public int getContIdByPelId(int pel_id) {
        int id = 0;
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT cont_id FROM peliculas "
                    + "WHERE pel_id = "
                    + pel_id;
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                //si llegan a existir dos contenidos con el mismo nombre
                //traerá el último id
                id = result.getInt(1);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return id;
    }
    
    public void updatecontenidoById(ContenidoModel contenidoModel){
        
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "UPDATE contenidos SET cont_titulo = " 
                    + "'" + contenidoModel.getCont_titulo() + "'"
                    + " WHERE cont_id = " + contenidoModel.getCont_id();
            
            PreparedStatement statement = conn.prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("Título del contenido Actualizado");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
