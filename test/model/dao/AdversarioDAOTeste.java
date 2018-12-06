/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Adversario;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author fabio
 */
public class AdversarioDAOTeste {

    public AdversarioDAOTeste() {
    }
    
    @Test
    @Ignore
    public void inserir() {
        Adversario adv = new Adversario();        
        AdversarioDAO dao = new AdversarioDAO();
        for(int i = 1; i < 11; i++){
            adv.setNome("team"+i);
            if(dao.inserir(adv)){
                System.out.println("team"+i+" foi salvo com sucesso");
            }
            else{
                fail("Erro ao salvar");
            }
        }        
    }
    
    @Test
    @Ignore
    public void atualizar() {
        Adversario adv = new Adversario("JAVA");
        adv.setId(1);
        AdversarioDAO dao = new AdversarioDAO();
        if(dao.update(adv)){
            System.out.println("Atualizado com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }
    
    @Test
//    @Ignore
    public void listar(){
        AdversarioDAO dao = new AdversarioDAO();

        for(Adversario a: dao.findall())
        {
            
            System.out.println("Nome: "+a.getNome());
            System.out.println("ID "+a.getId());
        }
    }
   
    @Test
    @Ignore
    public void deletar(){
        Adversario adv = new Adversario();
        adv.setId(1);
        AdversarioDAO dao = new AdversarioDAO();
        if(dao.delete(adv)){
            System.out.println("Deletado com sucesso");
        }
        else{
            fail("Erro ao deletar");
        }        
    } 
}
