/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Classificacao;
import model.bean.Confrontos;
import model.bean.Time;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author gabri
 */
public class ClassificacaoDAOTest {
    
    @Test
    public void inserir() {
        Confrontos confronto = new Confrontos();
        confronto.setNumeroJogo(2);
        Classificacao classificacao = new Classificacao("Batata", 43, confronto);
        ClassificacaoDAO dao = new ClassificacaoDAO();
        
        if(dao.inserir(classificacao)){
            System.out.println("Salvo com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
    }

}
