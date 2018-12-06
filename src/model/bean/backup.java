/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author fabio
 */
public class backup {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package model.bean;;
//
//import model.dao.*;
//import java.util.Scanner;
//import connection.*;
//
//public class Main {
//    public static void main (String [] args) {
//        Scanner s = new Scanner(System.in);
//        int opcao = 1, opcaoEsporte = -1;        
//        String login, senha;
//        boolean teste = true;
//                
//        Time time = new Time();
//        TimeDAO timedao = new TimeDAO(); 
//        Adversario adv = new Adversario();
//        AdversarioDAO advdao = new AdversarioDAO();
//        Confrontos conf = new Confrontos();
//        ConfrontosDAO confdao = new ConfrontosDAO();
//        Classificacao clas = new Classificacao();
//        ClassificacaoDAO clasdao = new ClassificacaoDAO();
//        ConnectionFactory conn = new ConnectionFactory();        
//        
//        Sql sql = new Sql();
//        
//        sql.gerarTableas();
//        
//        
//        while(teste == true){               
//            System.out.println("Digite a opcao desejada: ");
//            System.out.println("1 - Cadastrar");
//            System.out.println("2 - Entrar");
//            opcao = s.nextInt();
//            timedao.habilitar();
//            if(opcao == 1){
//                System.out.println("Escolha um login:");
//                time.setLogin(s.next());
//                System.out.println("Escolha uma senha:");
//                time.setSenha(s.next());                
//                if(timedao.inserir(time)){
//                    System.out.println("Salvo com sucesso");
//                    teste = false;                 
//                }
//                else{
//                    System.out.println("Erro ao salvar");                    
//                }                        
//            }
//            else if(opcao == 2){
//                System.out.println("Digite o login");
//                login = s.next();                
//                System.out.println("Digite a senha");
//                senha = s.next();                
//                for(Time t: timedao.findall()){
//                    if(t.getLogin().equals(login) && t.getSenha().equals(senha)){
//                        System.out.println("Logado com sucesso!");
//                        teste = false;                                      
//                    }
//                    else{
//                        System.out.println("Tente novamente!");                        
//                    }
//                }
//            }
//            else{
//                System.out.println("Opcao Invalida!");
//            }            
//        } 
//        teste = true;
//        while(teste == true){
//            System.out.println("Digite a opcao desejada: ");
//            System.out.println("1 - Cadastrar Time");
//            System.out.println("2 - Gerar Adversarios");
//            System.out.println("3 - Gerar Confrontos");
//            System.out.println("4 - Realizar Partida");
//            System.out.println("5 - Mostrar Tabela de Classificacao");
//            System.out.println("0 - Encerrar");
//            
//            if(opcao == 1){
//                System.out.println("Digite o nome do time:");
//                time.setNome(s.next());
//                while(opcaoEsporte != 0){
//                    System.out.println("Escolha o opçao de esporte:");
//                    System.out.println("1 - Futebol");
//                    System.out.println("2 - Volei");
//                    if(opcaoEsporte == 1){
//                        time.setTipoEsporte("Futebol");
//                    }
//                    else if(opcaoEsporte == 2){
//                        time.setTipoEsporte("Volei");
//                        teste= false;
//                    }
//                    else{
//                        System.out.println("Opcao Invalida!");
//                    }
//                }
//                System.out.println("Digite a quantidade de adversarios: ");
//                time.setQntTime(s.nextInt());
//                if(timedao.inserir(time)){
//                    System.out.println("Salvo com sucesso!");
//                    teste = false;
//                }
//                else{
//                    System.out.println("Erro ao salvar!");
//                }                 
//            }
//            else if(opcao == 2){
//                for(int i = 1; i <= time.getQntTime(); i++){
//                    adv.setNome("Team"+i);
//                }
//                if(advdao.inserir(adv)){
//                    System.out.println("Gerado com sucesso!");
//                    teste = false;
//                }
//                else{
//                    System.out.println("Erro ao gerar!");
//                }
//            }
//            else if(opcao == 3){
//                
//            }
//            else if(opcao == 4){
//                
//            }
//            else if(opcao == 5){
//                int i = 1;
//                System.out.println("Posicao  Pontos  Nome do Time");
//                for(Classificacao c: clasdao.findall()){
//                    System.out.printf("%01d       %02d    %s\n",i++ ,clas.getPontos(),clas.getNome());
//                }
//            }
//            else if(opcao == 0){
//                System.out.println("Encerrando a aplicacao!");
//                teste = false;
//            }
//            else{
//                System.out.println("Opcao Invalida!");
//                teste = false;
//            }                        
//        }                        
//    }
//}

    
}
