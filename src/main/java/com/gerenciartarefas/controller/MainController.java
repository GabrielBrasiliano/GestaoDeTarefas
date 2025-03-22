/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.controller;

import com.gerenciartarefas.model.dao.CategoriaDAO;
import com.gerenciartarefas.model.entities.Categoria;
import com.gerenciartarefas.model.entities.Usuario;
import com.gerenciartarefas.view.MainView;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Controle da classe principal.
 * 
 * @author GabrielBrasiliano
 */
public class MainController {

    private final MainView view;
    private final CategoriaDAO categoriaDAO;

    public MainController(MainView mainView, Usuario usuario) {
        this.view = mainView;
        this.categoriaDAO = new CategoriaDAO();

        carregarCategorias(usuario);
    }

    private void carregarCategorias(Usuario usuario) {

        List<Categoria> categorias = categoriaDAO.select("", "usuario_id=" + usuario.getId(), "");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorias");

        if (!categorias.isEmpty()) {
            for (int i = 0; i < categorias.size(); i++) {

                DefaultMutableTreeNode temp = new DefaultMutableTreeNode(categorias.get(i));
                root.add(temp);
            }
        }

        view.atualizarArvore(new DefaultTreeModel(root));
    }

}
