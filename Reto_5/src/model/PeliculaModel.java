/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joan Valencia
 */
public class PeliculaModel {
    private int pelId;
    private int contId_fk;
    private int dirId_fk;
    private String pelResumen;
    private int pelAnio; 
    private String contTitulo;
    private String dirNombre;

    public PeliculaModel(int pelId, int contId_fk, int dirId_fk, String pelResumen, 
            int pelAnio){
        this.pelId      = pelId;
        this.contId_fk  = contId_fk;
        this.dirId_fk   = dirId_fk;
        this.pelResumen = pelResumen;
        this.pelAnio    = pelAnio;
    }

    public PeliculaModel(int pelId, String contTitulo, String pelResumen, 
            String dirNombre, int pelAnio){
        this.pelId      = pelId;
        this.contTitulo = contTitulo;
        this.pelResumen = pelResumen;
        this.dirNombre  = dirNombre; 
        this.pelAnio    = pelAnio;
    }
    
    public PeliculaModel(int pelId, int cont_id, int dir_id, String contTitulo, 
            String pelResumen, int pelAnio){
        this.pelId = pelId;
        this.contId_fk = cont_id;
        this.dirId_fk = dir_id;
        this.contTitulo = contTitulo;
        this.pelResumen = pelResumen;
        this.pelAnio = pelAnio;
    }

    /**
     * @return the pelId
     */
    public int getPelId() {
        return pelId;
    }

    /**
     * @return the contId_fk
     */
    public int getContId_fk() {
        return contId_fk;
    }

    /**
     * @return the dirId_fk
     */
    public int getDirId_fk() {
        return dirId_fk;
    }

    /**
     * @return the pelResumen
     */
    public String getPelResumen() {
        return pelResumen;
    }

    /**
     * @param pelResumen the pelResumen to set
     */
    public void setPelResumen(String pelResumen) {
        this.pelResumen = pelResumen;
    }

    /**
     * @return the pelAnio
     */
    public int getPelAnio() {
        return pelAnio;
    }

    /**
     * @return the contTitulo
     */
    public String getContTitulo() {
        return contTitulo;
    }

    /**
     * @param contTitulo the contTitulo to set
     */
    public void setContTitulo(String contTitulo) {
        this.contTitulo = contTitulo;
    }

    /**
     * @return the dirNombre
     */
    public String getDirNombre() {
        return dirNombre;
    }
    
    public Object[] toArray(){
        Object[] data = {pelId, pelResumen, pelAnio, contTitulo, dirNombre};
        return data;
    }
}
