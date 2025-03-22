/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas;

import com.gerenciartarefas.controller.LoginController;
import com.gerenciartarefas.model.dao.UsuarioDAO;
import com.gerenciartarefas.view.LoginView;
import javax.swing.SwingUtilities;

/**
 * Classe pricipal que inicia a aplicação.
 * 
 * @author GabrielBrasiliano
 */
public class Main {

    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {

            LoginView view = new LoginView();
            UsuarioDAO model = new UsuarioDAO();
            new LoginController(view, model);

            view.setVisible(true);
        });
    }
}
