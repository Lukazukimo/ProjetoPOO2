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
import model.bean.Confrontos;
import model.bean.Time;

/**
 *
 * @author gabri
 */
public class ConfrontosDAO {
    private Connection con = null;

    public ConfrontosDAO() {
    con = connection.ConnectionFactory.getConnection();
    }
    
    public void habilitar(){
        con = connection.ConnectionFactory.getConnection();
    }
    
    public boolean inserir (Confrontos confronto) {
        habilitar();
//        String sql1 = "CREATE TABLE IF NOT EXISTS confronto("
//                + "nomeTime1 varchar(255),"
//                + "nomeTime2 varchar (255),"
//                + "resultadoIda int(1),"
//                + "numeroJogo int primary key AUTO_INCREMENT,"
//                + "id_time int(8),"
//                + "id_adversario int(8),"
//                + "FOREIGN KEY (id_time) references Times(id),"
//                + "FOREIGN KEY (id_adversario) references Adversario(id)"
//                + ")";
//        
        String sql = "INSERT INTO confronto (nomeTime1, nomeTime2, resultadoIda, "
                     + "id_time, id_adversario) "
                     + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try { 
//            stmt = con.prepareStatement (sql1);
            stmt = con.prepareStatement (sql);
            stmt.setString(1, confronto.getNomeTime1());
            stmt.setString(2, confronto.getNomeTime2());
            stmt.setInt(3, confronto.getResultadoIda());
//            stmt.setInt(4, confronto.getNumeroJogo());
            stmt.setInt(4, confronto.getTime().getId());
            stmt.setInt(5, confronto.getAdversario().getId());
//            stmt.execute(sql1);
            stmt.executeUpdate();
            return true; 
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Confrontos> findall () {        
        String sql = "SELECT * FROM Confronto INNER JOIN Times ON confronto.id_time = Times.id INNER JOIN Adversario on confronto.id_adversario = Adversario.id";
        PreparedStatement stmt = null; 
        ResultSet rs = null;
            
        List<Confrontos> confrontos = new ArrayList<>();
            
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Confrontos confronto = new Confrontos ();
                confronto.setNomeTime1(rs.getString("nomeTime1"));
                confronto.setNomeTime2(rs.getString("nomeTime2"));
                confronto.setResultadoIda(rs.getInt("resultadoIDA"));
                confronto.setNumeroJogo(rs.getInt("numeroJogo"));
                Time time = new Time();
                time.setId(rs.getInt("id"));
                Adversario adv = new Adversario();
                adv.setId(rs.getInt("id"));
                confronto.setTime(time);
                confronto.setAdversario(adv);
                confrontos.add(confronto);
            }

        }   
        catch (SQLException ex) {
           System.err.println("Erro: "+ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return confrontos;
    }
    
    /*public boolean update(Confrontos confronto, int numJogo){
            String sql = "UPDATE confronto SET time1 = ?, "
                    + "time2 = ?, "
                    + "resultadoIda = ?, "
                    + "WHERE numeroJogo = " + numJogo;
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, confronto.getNomeTime1());            
            stmt.setString(2, confronto.getNomeTime2());
            stmt.setInt(3, confronto.getResultadoIda());
            stmt.setInt(4, confronto.getNumeroJogo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    */
    public boolean delete(Confrontos confronto){
            String sql = "DELETE FROM confronto WHERE numeroJogo = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setInt(1, confronto.getNumeroJogo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}