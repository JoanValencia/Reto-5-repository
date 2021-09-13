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
public class ContenidoModel {
    private int cont_id;
    private String cont_titulo;

    public ContenidoModel(int cont_id, String cont_titulo) {
        this.cont_id = cont_id;
        this.cont_titulo = cont_titulo;
    }

    public int getCont_id() {
        return cont_id;
    }

    public String getCont_titulo() {
        return cont_titulo;
    }

    public void setCont_titulo(String cont_titulo) {
        this.cont_titulo = cont_titulo;
    }
}
