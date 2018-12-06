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
import model.bean.Time;

/**
 *
 * @author fabio
 */
public class TimeDAO {
    private Connection con = null;

    public TimeDAO() {
        con = connection.ConnectionFactory.getConnection(); //quando isntanciar vem a conexao/abre conexao
    }
    
    public void habilitar(){
        con = connection.ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Time time){
        con = connection.ConnectionFactory.getConnection();
        //comandos sql
//        String sql1 = "CREATE TABLE IF NOT EXISTS Times("
//                + "nome varchar(255),"
//                + "id int(8) primary key AUTO_INCREMENT,"
//                + "login varchar(255),"
//                + "senha varchar(255),"
//                + "tipoEsporte varchar(255),"
//                + "qntTime int(8)"
//                + ")";
        String sql2 = "INSERT INTO times (nome, login, senha, tipoEsporte, qntTime) "
                      + "VALUES(?, ?, ?, ?, ?) ";
        
        PreparedStatement stmt = null;
        try {
//            stmt = con.prepareStatement(sql1);
            stmt = con.prepareStatement(sql2);
            
            //definindo as posicoes dos valores nas colunas da tabela
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getLogin());
            stmt.setString(3, time.getSenha());
            stmt.setString(4, time.getTipoEsporte());
            stmt.setInt(5, time.getQntTime());
            
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
    
    
    public List<Time> findall(){
        habilitar();
        String sql = "SELECT * FROM Times";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Time> times = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Time time = new Time();
                //pegando do rs(do banco de dados) e colocando na classe
                time.setId(rs.getInt("id"));
                time.setNome(rs.getString("nome"));
                time.setLogin(rs.getString("login"));
                time.setSenha(rs.getString("senha"));
                time.setTipoEsporte(rs.getString("tipoEsporte"));
                time.setQntTime(rs.getInt("qntTime"));
                times.add(time);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return times;
    }
    
    public boolean update(Time time){
        habilitar();
            String sql = "UPDATE times SET nome = ?, "
//                    + "login = ?, "
//                    + "senha = ?, "
                    + "tipoEsporte = ?, "
                    + "qntTime = ? "
                    + "WHERE id = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, time.getNome());            
//            stmt.setString(2, time.getLogin());
//            stmt.setString(3, time.getSenha());
            stmt.setString(2, time.getTipoEsporte());
            stmt.setInt(3, time.getQntTime());
            stmt.setInt(4, time.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt); //fecha a conexao
        }
    }
    
    public boolean delete(Time time){
            String sql = "DELETE FROM time WHERE id = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setInt(1, time.getId());
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
