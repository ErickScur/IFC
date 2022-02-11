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
import help.model.Chamado;
import help.model.Filtro;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ChamadoDAO {

    private Connection conexao;

    public ChamadoDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    public int inserirChamado(Chamado chamado) {
        int resultado = 0;

        try {

            String sql = "insert into chamado (titulo, corpo, idusuario, idanalista, idcategoria, datacriacao, status, urgencia) values (?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, chamado.getTitulo());
            stmt.setString(2, chamado.getCorpo());
            stmt.setInt(3, chamado.getIdUsuario());
            stmt.setInt(4, chamado.getIdAnalista());
            stmt.setInt(5, chamado.getIdCategoria());
            stmt.setTimestamp(6, chamado.getDataCriacao());
            stmt.setInt(7, chamado.getStatus());
            stmt.setString(8, chamado.getUrgencia());
            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }

    public List<Chamado> consultarChamados(Filtro filtro) {
        String sql = "select * from chamado";
        if(!filtro.mostrarFinalizados){
                sql += " where (status=0 or status=1)";
        }
        if(filtro.temCategoria || filtro.temUsuario|| filtro.temAnalista){
            if(filtro.mostrarFinalizados)
                sql+= " where ";
            else
                sql += " and ";
            if(filtro.temCategoria){
                sql += " idcategoria="+filtro.getCategoria();
                if(filtro.temAnalista)
                    sql += " and idanalista="+filtro.getAnalista();
                if(filtro.temUsuario)
                    sql += " and idusuario="+filtro.getUsuario();                 
            }else if(filtro.temAnalista){
                sql += " idanalista="+filtro.getAnalista();
                if(filtro.temUsuario)
                    sql += " and idusuario="+filtro.getUsuario();
                if(filtro.temCategoria)
                    sql += " and idcategoria="+filtro.getCategoria();
            }else if(filtro.temUsuario){
                sql += " idusuario="+filtro.getUsuario();
                if(filtro.temCategoria)
                    sql += " and idcategoria="+filtro.getCategoria();
                if(filtro.temAnalista)
                    sql += " and idanalista="+filtro.getAnalista();
            }
        }
        sql += " order by status";
        System.out.println(sql);
        
        List<Chamado> chamados = new ArrayList<>();
        Statement stmt;
        ResultSet rs = null;
        Chamado chamado = null;

        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                chamado = new Chamado();
                chamado.setTitulo(rs.getString("titulo"));
                chamado.setCorpo(rs.getString("corpo"));
                chamado.setIdAnalista(rs.getInt("idanalista"));
                chamado.setIdUsuario(rs.getInt("idusuario"));
                chamado.setIdCategoria(rs.getInt("idcategoria"));
                chamado.setId(rs.getInt("id"));
                chamado.setStatus(rs.getInt("status"));
                chamado.setUrgencia(rs.getString("urgencia"));
                chamado.setDataFinalizacao(rs.getTimestamp("datafinalizacao"));
                chamado.setDataCriacao(rs.getTimestamp("datacriacao"));
                chamado.setResposta(rs.getString("resposta"));
                chamados.add(chamado);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return chamados;
    }
    public Chamado consultarChamado(int id){
        ResultSet rs = null;
        Chamado chamado = null;
        try {
            String sql = "select * from chamado where id=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                chamado = new Chamado();
                chamado.setTitulo(rs.getString("titulo"));
                chamado.setCorpo(rs.getString("corpo"));
                chamado.setIdAnalista(rs.getInt("idanalista"));
                chamado.setIdUsuario(rs.getInt("idusuario"));
                chamado.setIdCategoria(rs.getInt("idcategoria"));
                chamado.setId(rs.getInt("id"));
                chamado.setStatus(rs.getInt("status"));
                chamado.setUrgencia(rs.getString("urgencia"));
                chamado.setDataFinalizacao(rs.getTimestamp("datafinalizacao"));
                chamado.setDataCriacao(rs.getTimestamp("datacriacao"));
                chamado.setResposta(rs.getString("resposta"));
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return chamado;
    }
    public int iniciarAtendimento(int id, int analista){
        int resultado = 0;

        try {

            String sql = "update chamado set status=1, idanalista=? where id=?";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, analista);
            stmt.setInt(2, id);
            
            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return resultado;
    }
    public int finalizarAtendimento(int id, String resposta){
        int resultado = 0;

        try {

            String sql = "update chamado set resposta=?, datafinalizacao=?, status=2 where id=?";

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, resposta);
            stmt.setDate(2, new Date(new java.util.Date().getTime()));
            stmt.setInt(3, id);

            resultado = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return resultado;
    }
    public int removerChamado(int id) {
        String sql = "delete from chamado where id=?";
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

    public String statusToString(int status){
        switch(status){
            case 0:
                return "Em espera";
            case 1:
                return "Atendimento Iniciado";
            case 2:
                return "Finalizado";
            default:
                return "";
        }
    }
    public String timeStamptoString(Timestamp time){
        String dia;
        int diaTime = time.getDay();
        if(diaTime >= 10)
            dia = String.valueOf(diaTime);
        else
            dia = "0" + String.valueOf(diaTime);
        
        int mesTime = time.getMonth() + 1;
        String mes;
        if(mesTime >= 10)
            mes = String.valueOf(mesTime);
        else
            mes = "0" + String.valueOf(mesTime);
        String ano = time.toString().substring(0,4);
        
        int horasTime = time.getHours();
        String horas;
        if(horasTime >= 10)
            horas = String.valueOf(horasTime);
        else
            horas = "0" + String.valueOf(horasTime);
        
        int minutosTime = time.getMinutes();
        String minutos;
        if(minutosTime >= 10)
            minutos = String.valueOf(minutosTime);
        else
            minutos = "0" + String.valueOf(minutosTime);
                
        return dia+"/"+mes+"/"+ano+" - "+horas+":"+minutos;
    }
}
