/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.model;

/**
 *
 * @author erick
 */
public class Categoria {
    private int id;
    private String nome;

    public Categoria() {
        
    }
    public Categoria(String nome){
        this.nome = nome;
    }
    public Categoria(String nome, int id){
        this.nome = nome;
        this.id = id;
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
}
