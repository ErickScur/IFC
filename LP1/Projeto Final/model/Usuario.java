/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.model;

/**
 *
 * @author erick
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private boolean isAnalista;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, boolean isAnalista) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAnalista = isAnalista;
    }

    public Usuario(int id, String nome, String email, String senha, boolean isAnalista) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAnalista = isAnalista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAnalista() {
        return isAnalista;
    }

    public void setAnalista(boolean isAnalista) {
        this.isAnalista = isAnalista;
    }
}
