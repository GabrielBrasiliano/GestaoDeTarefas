/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.controller;

import com.gerenciartarefas.model.dao.CategoriaDAO;
import com.gerenciartarefas.model.entities.Categoria;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe controle para categorias de tarefas.
 * 
 * @author GabrielBrasiliano
 */
public class CategoriaController {

    private final CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public boolean insert(String nome, long usuario_id) {

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome!");
            return false;
        }
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        categoria.setUsuario_id(usuario_id);

        return categoriaDAO.insert(categoria);
    }

    public List<Categoria> select(long usuario_id) {
        return categoriaDAO.select("", "", "");
    }

}
