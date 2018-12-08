/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Time;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import model.bean.Time;

/**
 *
 * @author fabio
 */
public class TimeDAOTest {
    
    public TimeDAOTest() {
    }

    @Test
    //@Ignore
    public void inserir() {
        Time tim = new Time("team1", "a123", "futebol", 10);
        TimeDAO dao = new TimeDAO();
        if(dao.inserir(tim)){
            System.out.println("Salvo com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }
    @Test
    @Ignore
    public void atualizar() {
        Time tim = new Time("team1", "a12346", "futebol", 10);
        tim.setId(1);
        TimeDAO dao = new TimeDAO();
        if(dao.update(tim)){
            System.out.println("Atualizado com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }
    @Test
    @Ignore
    public void listar(){
        TimeDAO dao = new TimeDAO();
        for(Time t: dao.findall()){
            System.out.println("Nome: "+t.getNome());
            System.out.println("Login: "+t.getLogin());
            System.out.println("Senha: "+t.getSenha());
            System.out.println("Tipo de Esporte: "+t.getTipoEsporte());
            System.out.println("Quantidade de Times: "+t.getQntTime());
        }
    }
    
    @Test
    @Ignore
    public void deletar(){
        Time tim = new Time();
        tim.setId(1);
        TimeDAO dao = new TimeDAO();
        if(dao.delete(tim)){
            System.out.println("Deletado com sucesso");
        }
        else{
            fail("Erro ao deletar");
        }        
    }   
    /*
    @Test
    @Ignore
    public static void main(String []args){
        Time tim = new Time();
        tim.gerarTime(10);
    }*/
}
