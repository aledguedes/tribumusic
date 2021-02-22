/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tribumusic.model;

import java.util.List;

/**
 *
 * @author alexa
 */
public class Usuario implements java.io.Serializable {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private List<PlayList> paylists;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the paylists
     */
    public List<PlayList> getPaylists() {
        return paylists;
    }

    /**
     * @param paylists the paylists to set
     */
    public void setPaylists(List<PlayList> paylists) {
        this.paylists = paylists;
    }
    
    public String toString(){
        return id+"    "+nome+"   "+email; 
    }

    /**
     * @return the paylist
     */
    
     
}
