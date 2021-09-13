/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DirectorModel;
import model.PeliculaModel;
import utils.ConnectionDB;

/**
 *
 * @author gefry
 */
public class DirectorDAO {
    
    private Connection conn = null;
       
    public ArrayList<DirectorModel> getAllDirectoresList(){
        ArrayList<DirectorModel> directores = new ArrayList<>();
        try{
            if(conn == null)
                    conn = ConnectionDB.getConnection();

            String sql = "SELECT dir_id, CONCAT(dir_nombre, ' ', dir_apellido) "
                    + "FROM director "
                    + "ORDER BY dir_apellido;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                DirectorModel director = new DirectorModel(result.getInt(1), 
                        result.getString(2));
                directores.add(director);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return directores;
    }
}
