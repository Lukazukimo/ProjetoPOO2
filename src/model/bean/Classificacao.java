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
public class Classificacao {
    private int idClass; 
    private String nome;
//    private int pos;
    private int pontos;
    private Confrontos confrontos;

    public Classificacao() {
    }

    public Classificacao(String nome, int pontos, Confrontos confrontos) {
        this.nome = nome;
//        this.pos = pos;
        this.pontos = pontos;
        this.confrontos = confrontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

//    public int getPos() {
//        return pos;
//    }
//
//    public void setPos(int pos) {
//        this.pos = pos;
//    }

    public Confrontos getConfrontos() {
        return confrontos;
    }

    public void setConfrontos(Confrontos confrontos) {
        this.confrontos = confrontos;
    }
    
    public void gerarConfrontos () {
        
    }
    
}
