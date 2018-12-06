package model.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.bean.Adversario;
import model.bean.Confrontos;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import model.bean.Time;

/**
 *
 * @author gabri
 */
public class ConfrontosDAOTest {
    public ConfrontosDAOTest () {}


    @Test
//    @Ignore
    public void inserisr() {
        Adversario adv = new Adversario();
        adv.setId(4);
        Time tim = new Time();
        tim.setId(1);
        Confrontos conf = new Confrontos("team1", "team2", 1, tim, adv);
        ConfrontosDAO dao = new ConfrontosDAO();
        if(dao.inserir(conf)){
            System.out.println("Salvo com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }
  @Test
  @Ignore
  public void listar(){
        ConfrontosDAO dao = new ConfrontosDAO();
        for(Confrontos t: dao.findall()){
            System.out.println("Nome Time 1: "+t.getNomeTime1());
            System.out.println("Nome Time 2: "+t.getNomeTime2());
            System.out.println("Resultado do Jogo: "+t.getResultadoIda());
            System.out.println("Numero do Jogo: "+t.getNumeroJogo());
            
        }
    } 
  
   @Test
   @Ignore
    public void deletar(){
        Confrontos conf = new Confrontos();
        conf.setNumeroJogo(1);
        ConfrontosDAO dao = new ConfrontosDAO();
        if(dao.delete(conf)){
            System.out.println("Deletado com sucesso");
        }
        else{
            fail("Erro ao deletar");
        }        
    } 
    
    //@Test
/*public void atualizar() {
        
        Time tim = new Time();
        tim.setId(1);
        Confrontos conf = new Confrontos("team4", "team24", 1, tim);
        conf.setNumeroJogo(2);
        ConfrontosDAO dao = new ConfrontosDAO();
        if(dao.update(conf, 2)){
            System.out.println("Atualizado com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }

*/
}