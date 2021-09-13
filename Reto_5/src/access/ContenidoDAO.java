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
import model.ContenidoModel;
import model.DirectorModel;
import utils.ConnectionDB;

/**
 *
 * @author gefry
 */
public class ContenidoDAO {
    private Connection conn = null;
    
    public ArrayList<DirectorModel> insertContenido(ContenidoModel contenidoModel){
        ArrayList<DirectorModel> directores = new ArrayList<>();
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
        return directores;
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
}
