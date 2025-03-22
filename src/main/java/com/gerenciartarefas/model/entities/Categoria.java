/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.model.entities;

/**
 * Classe Categoria.
 *
 * @author GabrielBrasiliano
 */
public class Categoria {

    private long id;
    private long usuario_id;
    private String nome;

    public Categoria() {

    }

    public Categoria(long id, long usuario_id, String nome) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the usuario_id
     */
    public long getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
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

    public String toString() {
        return getNome();
    }

}
