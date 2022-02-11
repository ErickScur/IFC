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
import help.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    public int inserirUsuario(Usuario usuario) {
        int resultado = 0;

        try {

            String sql = "insert into usuario (nome, email, senha, isAnalista) values (?,?,?,?)";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setBoolean(4, usuario.isAnalista());

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }

    public List<Usuario> consultarUsuarios() {
        String sql = "select * from usuario";
        List<Usuario> usuarios = new ArrayList<>();
        Statement stmt;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setId(rs.getInt("id"));
                usuario.setAnalista(rs.getBoolean("isAnalista"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return usuarios;
    }
    public List<Usuario> consultarUsuariosClientes() {
        String sql = "select * from usuario where isAnalista=0";
        List<Usuario> usuarios = new ArrayList<>();
        Statement stmt;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setId(rs.getInt("id"));
                usuario.setAnalista(rs.getBoolean("isAnalista"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return usuarios;
    }
    public int removerUsuario(int id) {
        String sql = "delete from usuario where id=?";
        int resultado = 0;

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return resultado;
    }

    public int atualizarUsuario(Usuario usuario) {
        int resultado = 0;
        try {

            String sql = "update usuario set nome=?, email=?, senha=?, isAnalista=? where id=?";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setBoolean(4, usuario.isAnalista());
            stmt.setInt(5, usuario.getId());

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }
    public Usuario consultarUsuario(int id){
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            String sql = "select * from usuario where id=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAnalista(rs.getBoolean("isAnalista"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuario;
    }
    public Usuario consultarUsuarioNome(String nome){
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            String sql = "select * from usuario where nome=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAnalista(rs.getBoolean("isAnalista"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuario;
    }
    public Usuario login(String email, String senha){
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            String sql = "select * from usuario where email=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, email);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                if(!(senha.equals(rs.getString("senha"))))
                    return null;
                usuario.setAnalista(rs.getBoolean("isAnalista"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return usuario;
    }
}
