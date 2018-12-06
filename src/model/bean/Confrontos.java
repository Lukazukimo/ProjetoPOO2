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
public class Confrontos {
    private String nomeTime1;
    private String nomeTime2;
    private int resultadoIda;
    private Time time;
    private int numeroJogo;
    private Adversario adversario;
    

    public Adversario getAdversario() {
        return adversario;
    }

    public void setAdversario(Adversario adversario) {
        this.adversario = adversario;
    }
    

    public Confrontos(String nomeTime1, String nomeTime2, int resultadoIda, Time time, Adversario adversario) {
        this.nomeTime1 = nomeTime1;
        this.nomeTime2 = nomeTime2;
        this.resultadoIda = resultadoIda;
        this.time = time;
        this.adversario = adversario;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getNumeroJogo() {
        return numeroJogo;
    }

    public void setNumeroJogo(int numeroJogo) {
        this.numeroJogo = numeroJogo;
    }

    public Confrontos() {
    }

    public String getNomeTime1() {
        return nomeTime1;
    }

    public void setNomeTime1(String nomeTime1) {
        this.nomeTime1 = nomeTime1;
    }

    public String getNomeTime2() {
        return nomeTime2;
    }

    public void setNomeTime2(String nomeTime2) {
        this.nomeTime2 = nomeTime2;
    }

    public int getResultadoIda() {
        return resultadoIda;
    }

    public void setResultadoIda(int resultadoIda) {
        this.resultadoIda = resultadoIda;
    }
        
    public int getAdversarioId(){
        return adversario.getId();
    }
    
    public int getTimeId(){
        return time.getId();
    }
    
}
