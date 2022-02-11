/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.dao;

/**
 *
 * @author erick
 */
import help.bd.ConexaoBD;
import help.model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    private Connection conexao;

    public CategoriaDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    public int inserirCategoria(Categoria categoria) {
        int resultado = 0;

        try {
            String sql = "insert into categoria (nome) values (?)";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }

    public List<Categoria> consultarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "select * from categoria";

        Statement stmt;
        ResultSet rs = null;
        Categoria categoria = null;

        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));

                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return categorias;
    }

    public int removerCategoria(int id) {
        String sql = "delete from categoria where id=?";
        int resultado = 0;

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }

    public int atualizarCategoria(Categoria categoria) {
        int resultado = 0;

        try {

            String sql = "update categoria set nome=? where id=?";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            stmt.setInt(2, categoria.getId());

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }
    public Categoria consultarCategoria(int id){
        ResultSet rs = null;
        Categoria categoria = null;
        try {
            String sql = "select * from categoria where id=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return categoria;
    }
    public Categoria consultarCategoriaNome(String nome){
        ResultSet rs = null;
        Categoria categoria = null;
        try {
            String sql = "select * from categoria where nome=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return categoria;
    }

}
