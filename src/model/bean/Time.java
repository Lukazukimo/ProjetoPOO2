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
public class Time {
    private String nome;
    private int id;
    private String login;
    private String senha;
    private String tipoEsporte;
    private int qntTime;

    public Time() {
    }

    public Time(String nome, String login, String senha, String tipoEsporte, int qntTime) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipoEsporte = tipoEsporte;
        this.qntTime = qntTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoEsporte() {
        return tipoEsporte;
    }

    public void setTipoEsporte(String tipoEsporte) {
        this.tipoEsporte = tipoEsporte;
    }

    public int getQntTime() {
        return qntTime;
    }

    public void setQntTime(int qntTime) {
        this.qntTime = qntTime;
    }
    
    
}
