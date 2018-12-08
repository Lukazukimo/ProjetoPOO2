/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.*;
import java.util.Scanner;
import connection.*;
import java.util.Random;

public class Main {
    public static void main (String [] args) {
        Scanner s = new Scanner(System.in);
        int opcao = 1, opcaoEsporte = -1, qntTimes = 0;        
        String login, senha;
        boolean teste = true, escolheTime = true, verificaCadastro = true;        
                
        Time time = new Time();
        TimeDAO timedao = new TimeDAO(); 
        Adversario adv = new Adversario();
        AdversarioDAO advdao = new AdversarioDAO();
        Confrontos conf = new Confrontos();
        ConfrontosDAO confdao = new ConfrontosDAO();
        Random geradorResultado = new Random();
//        ConnectionFactory conn = new ConnectionFactory();        
        
        
        Sql sql = new Sql();
        
        sql.gerarTableas();
        
        
        while(teste == true){               
            System.out.println("Digite a opcao desejada: ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Entrar");
            opcao = s.nextInt();
            timedao.habilitar();
            if(opcao == 1){
                System.out.println("Escolha um login:");
                time.setLogin(s.next());
                System.out.println("Escolha uma senha:");
                time.setSenha(s.next());                
                if(timedao.inserir(time)){
                    System.out.println("Salvo com sucesso");
                    teste = false;                 
                }
                else{
                    System.out.println("Erro ao salvar");                    
                }                        
            }
            else if(opcao == 2){
                System.out.println("Digite o login");
                login = s.next();                
                System.out.println("Digite a senha");
                senha = s.next();                
                for(Time t: timedao.findall()){
                    if(t.getLogin().equals(null) && t.getSenha().equals(null)){
                        System.out.println("Nao cadastrado!");  
                    }
                    else{
                        if(t.getLogin().equals(login) && t.getSenha().equals(senha)){                        
                            System.out.println("Logado com sucesso!");
                            teste = false;                                      
                        }
                        else{
                            System.out.println("Tente novamente!");                        
                        }  
                    }
                }                     
            }
            else{
                System.out.println("Opcao Invalida!");
            }            
        } 
        teste = true;
        while(teste == true){
            System.out.println("Digite a opcao desejada: ");
            System.out.println("1 - Cadastrar Time");
            System.out.println("2 - Gerar Adversarios");
            System.out.println("3 - Gerar Confrontos");
            System.out.println("4 - Realizar Partida");
            System.out.println("5 - Mostrar Tabela de Classificacao");
            System.out.println("0 - Encerrar");
            opcao = s.nextInt();
            if(opcao == 1 && verificaCadastro == true){
                System.out.println("Digite o nome do time:");
                time.setNome(s.next());                
                while(escolheTime == true){
                    System.out.println("Escolha o opcao de esporte:");
                    System.out.println("1 - Futebol");
                    System.out.println("2 - Volei");
                    opcaoEsporte = s.nextInt();
                    if(opcaoEsporte == 1){
                        time.setTipoEsporte("Futebol");
                        escolheTime = false;
                    }
                    else if(opcaoEsporte == 2){
                        time.setTipoEsporte("Volei");   
                        escolheTime = false;
                    }
                    else{
                        System.out.println("Opcao Invalida!");
                    }
                }
                System.out.println("Digite a quantidade de adversarios: ");
                time.setQntTime(s.nextInt());
                time.setId(1);
                if(timedao.update(time)){
                    System.out.println("Salvo com sucesso!");                    
                }
                else{
                    System.out.println("Erro ao salvar!");
                }   
                verificaCadastro = false;
            }
            else if(opcao == 2){                
                for(Time t: timedao.findall()){              
                    qntTimes = t.getQntTime();                    
                }
                for(int i = 1; i <= qntTimes; i++){
                    adv.setNome("Team"+i);
                    if(advdao.inserir(adv)){
                        System.out.println("Gerado com sucesso!");
                    }
                    else{
                        System.out.println("Erro ao gerar!");
                    }
                }                
            }
            else if(opcao == 3){  
                for(Time t: timedao.findall()){
                    for(Adversario adver: advdao.findall()){                                   
                        conf.setNomeTime1(t.getNome());                        
                        conf.setNomeTime2(adver.getNome());                         
                        conf.setAdversario(adver);                        
                        conf.setTime(t);   
                        if(confdao.inserir(conf)){
                            System.out.println("Gerado com sucesso!");
                        }
                        else{
                            System.out.println("Erro ao gerar!");
                        }
                    }
                }
            }
            else if(opcao == 4){          
                for(Confrontos confr: confdao.findall()){
                    confr.getNumeroJogo();                           
                    confr.setResultadoIda(geradorResultado.nextInt(2));                               
                    if(confdao.update(confr)){
                        System.out.println("Partida terminada!");
                    }
                    else{
                        System.out.println("Erro ao comecar a partida!");
                    }
                }   
            }      
            else if(opcao == 5){                
                for(Confrontos confr: confdao.findall()){
                    if(confr.getResultadoIda() == 1){
                        System.out.println(confr.getNomeTime1()+" x "+confr.getNomeTime2()+" Vitoria");                        
                    }
                    else{
                        System.out.println(confr.getNomeTime1()+" x "+confr.getNomeTime2()+" Derrota");
                    }
                }
            }            
            else if(opcao == 0){
                System.out.println("Encerrando a aplicacao!");
                teste = false;
            }
            else{
                System.out.println("Opcao Invalida!");
            }                        
        }                        
    }
}
