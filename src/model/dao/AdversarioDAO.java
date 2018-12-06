/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Adversario;
import model.bean.Time;

/**
 *
 * @author fabio
 */
public class AdversarioDAO {
    private Connection con = null;

    public AdversarioDAO() {
        con = connection.ConnectionFactory.getConnection();        
    }
    
    public boolean inserir(Adversario adversario){
        //comandos sql
        con = connection.ConnectionFactory.getConnection();    
//        String sql1 = "CREATE TABLE IF NOT EXISTS Adversario("
//                + "nome varchar(255),"
//                + "id int(8) primary key AUTO_INCREMENT"
//                + ")";
        String sql2 = "INSERT INTO adversario (nome) VALUES(?)";
        
        PreparedStatement stmt = null;
        try {
//            stmt = con.prepareStatement(sql1);
            stmt = con.prepareStatement(sql2);
            
            //definindo as posicoes dos valores nas colunas da tabela
            stmt.setString(1, adversario.getNome());
            
//            stmt.execute(sql1); //executa os comandos sqls
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexao
        }        
    }
    
    public List<Adversario> findall(){
        String sql = "SELECT * FROM Adversario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Adversario> adversarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Adversario adversario = new Adversario();
                //pegando do rs(do banco de dados) e colocando na classe
                adversario.setNome(rs.getString("nome"));
                adversario.setId(rs.getInt("id"));
                adversarios.add(adversario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return adversarios;
    }
    
    public boolean update(Adversario adversario){
        String sql = "UPDATE adversario SET nome = ? "
                   + "WHERE id = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, adversario.getNome());            
            stmt.setInt(2, adversario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexao
        }
    }
    
    public boolean delete(Adversario adversario){
            String sql = "DELETE FROM adversario WHERE id = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setInt(1, adversario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexao
        }
    }
}
