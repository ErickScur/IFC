/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.model;

/**
 *
 * @author erick
 */
public class Filtro {
    private int categoria;
    private int usuario;
    private int analista;
    public boolean temCategoria=false;
    public boolean temUsuario=false;
    public boolean temAnalista=false;
    public boolean mostrarFinalizados=false;
    
    public Filtro(){
        this.categoria = 0;
        this.usuario = 0;
        this.analista = 0;
    }
    public Filtro(int cat, int usu, int ana){
        this.categoria = cat;
        this.usuario = usu;
        this.analista = ana;
    }
    public void setCategoria(int cat){
        this.categoria = cat;
        this.temCategoria = cat != 0;
    }
    public int getCategoria(){
        return this.categoria;
    }
    public void setUsuario(int usu){
        this.usuario = usu;
        this.temUsuario = usu != 0;
    }
    public int getUsuario(){
        return this.usuario;
    }
    public int getAnalista(){
        return this.analista;
    }
    public void setAnalista(int ana){
        this.analista = ana;
        this.temAnalista = ana != 0;
    }
    public void setMostrarFinalizados(boolean mos){
        this.mostrarFinalizados = mos;
    }
}
