/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gefry
 */
public class DirectorModel {
    
    private int     dir_id;
    private String  dir_nombre;
    
    public DirectorModel(int dir_id, String dir_nombre){
        
        this.dir_id = dir_id;
        this.dir_nombre = dir_nombre;
    }

    public int getDir_id() {
        return dir_id;
    }

    public String getDir_nombre() {
        return dir_nombre;
    }

    public void setDir_nombre(String dir_nombre) {
        this.dir_nombre = dir_nombre;
    }

}
