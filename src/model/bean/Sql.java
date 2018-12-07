/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author fabio
 */
public class Sql {
    private Connection con = null;
    PreparedStatement stmt = null;

    public void gerarTableas() {
        con = connection.ConnectionFactory.getConnection();
    
    String sql1 = "CREATE TABLE IF NOT EXISTS Times("
                + "nome varchar(255),"
                + "id int(8) primary key AUTO_INCREMENT,"
                + "login varchar(255),"
                + "senha varchar(255),"
                + "tipoEsporte varchar(255),"
                + "qntTime int(8)"
                + ")";
    String sql2 = "CREATE TABLE IF NOT EXISTS Adversario("
                + "nome varchar(255),"
                + "id int(8) primary key AUTO_INCREMENT"
                + ")";
    String sql3 = "CREATE TABLE IF NOT EXISTS confronto("
                + "nomeTime1 varchar(255),"
                + "nomeTime2 varchar (255),"
                + "resultadoIda int(1),"
                + "numeroJogo int(8) primary key AUTO_INCREMENT,"
                + "id_time int(8),"
                + "id_adversario int(8),"
                + "FOREIGN KEY (id_time) references Times(id),"
                + "FOREIGN KEY (id_adversario) references Adversario(id)"
                + ")";
    String sql4 = "CREATE TABLE IF NOT EXISTS classificacao("
                + "id_class int(2) primary key AUTO_INCREMENT,"
                + "nome varchar (255),"
                + "pontos int (3),"
//                + "posicao int (2),"
                + "confrontos_class int (8),"
                + "FOREIGN KEY (confrontos_class) references confronto (numeroJogo)"
                + ")";
    
        try {
            stmt = con.prepareStatement (sql1);
            stmt = con.prepareStatement (sql2);
            stmt = con.prepareStatement (sql3);
            stmt = con.prepareStatement (sql4);
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }            
    }    
}
