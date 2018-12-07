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
import model.bean.Classificacao;
import model.bean.Confrontos;

/**
 *
 * @author gabri
 */
public class ClassificacaoDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private Connection con = null;

    public ClassificacaoDAO() {
    con = connection.ConnectionFactory.getConnection();
    }
    public void habilitar(){
        con = connection.ConnectionFactory.getConnection();
    }
    
    public boolean inserir (Classificacao classificacao) {
//        String sql1 = "CREATE TABLE IF NOT EXISTS classificacao("
//                + "id_class int(2) primary key AUTO_INCREMENT,"
//                + "nome varchar (255),"
//                + "pontos int (3),"
////                + "posicao int (2),"
//                + "confrontos_class int (2),"
//                + "FOREIGN KEY (confrontos_class) references Confronto (numeroJogo)"
//                + ")";
//        
        habilitar();
            String sql = "INSERT INTO classificacao (nome, pontos, "
                     + "confrontos_class) "
//                     + "VALUES (?, ?, ?, ?)";
                     + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try { 
//            stmt = con.prepareStatement (sql1);
            stmt = con.prepareStatement (sql);
            stmt.setString(1, classificacao.getNome());
            stmt.setInt(2, classificacao.getPontos());
//            stmt.setInt(3, classificacao.getPos());
            stmt.setInt(3, classificacao.getConfrontosId());            
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
    public List<Classificacao> findall () {
        habilitar();
        String sql = "SELECT * FROM classificacao INNER JOIN confronto ON classificacao.id_class = confronto.numeroJogo";
        PreparedStatement stmt = null; 
        ResultSet rs = null;
            
        List<Classificacao> classificacao = new ArrayList<>();
            
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Classificacao classificacoes = new Classificacao();
                classificacoes.setNome(rs.getString("nome"));
//                classificacoes.setPos(rs.getInt("posicao"));
                classificacoes.setPontos(rs.getInt("pontos"));
                classificacoes.setIdClass(rs.getInt("id_class"));
                Confrontos confrontos = new Confrontos();
                confrontos.setNumeroJogo(rs.getInt("numeroJogo"));
                classificacoes.setConfrontos(confrontos);
                classificacao.add(classificacoes);                                                       
            }

        }   
        catch (SQLException ex) {
           System.err.println("Erro: "+ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return classificacao;
    }
   
    
    public boolean update(Classificacao classificacao){
        habilitar();
            String sql = "UPDATE classificacao SET nome = ?, "
                    + "pontos = ? "
                    + "WHERE id_class = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, classificacao.getNome());            
            stmt.setInt(2, classificacao.getPontos());
            stmt.setInt(3, classificacao.getIdClass());            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
//    public boolean delete(Confrontos confronto){
//            String sql = "DELETE FROM confronto WHERE numeroJogo = ?";
//        
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement(sql);
//                  
//            stmt.setInt(1, confronto.getNumeroJogo());
//            stmt.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            System.err.println("Erro: "+ex);
//            return false;
//        } finally{
//            ConnectionFactory.closeConnection(con, stmt);
//        }
//    }
}

