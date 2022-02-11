/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.model;

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author erick
 */
public class Chamado {
    private int id;
    private int idUsuario;
    private int idAnalista=0;
    private int idCategoria;
    private String titulo;
    private String corpo;
    private Timestamp dataCriacao;
    private String resposta;
    private int status;
    private String urgencia;
    private Timestamp dataFinalizacao;
    
    public Chamado() {        
        this.dataCriacao = new Timestamp(new java.util.Date().getTime());
        this.idAnalista = 0;
        this.status = 0;
    }
    
    public Chamado(String titulo, String corpo, int idCategoria, int idUsuario, int status, String urgencia) {        
        this.titulo = titulo;
        this.corpo = corpo;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.dataCriacao = new Timestamp(new java.util.Date().getTime());
        this.status = status;
        this.urgencia = urgencia;
    }
     
    public Chamado(int id, String titulo, String corpo, int idCategoria, int idUsuario, int status, String urgencia) {        
        this.id = id;
    	this.titulo = titulo;
        this.corpo = corpo;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.dataCriacao = new Timestamp(new java.util.Date().getTime());
        this.status = status;
        this.urgencia = urgencia;
    }
    
    public Timestamp getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Timestamp dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
    
    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }
    
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String getResposta(){
        return this.resposta;
    }
    public void setResposta(String resposta){
        this.resposta = resposta;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public Timestamp getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Timestamp date){
        this.dataCriacao = date;
    }
}
