/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.controller;

import com.gerenciartarefas.model.dao.UsuarioDAO;
import com.gerenciartarefas.model.entities.Usuario;
import com.gerenciartarefas.view.LoginView;
import com.gerenciartarefas.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que valida o login de acesso no usuário.
 * 
 * @author GabrielBrasiliano
 */
public class LoginController {

    private LoginView view;
    private final UsuarioDAO usuarioDAO;

    public LoginController(LoginView view, UsuarioDAO model) {
        this.usuarioDAO = model;

        this.view = view;
        this.view.loginListener(new LoginListener());
        this.view.cancelarListener(new CancelarListener());
    }

    class CancelarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String login = view.getLogin();
            String senha = view.getSenha();

            if (login.isEmpty() || senha.isEmpty()) {
                view.showMessage("Preencha todos os campos!");

            } else {
                Usuario user = usuarioDAO.validarAcesso(login, senha);

                if (user == null) {
                    view.showMessage("Login ou senha inválidos!");

                } else {
                    view.dispose();

                    MainView mainView = new MainView();
                    new MainController(mainView, user);
                    mainView.setVisible(true);
                }
            }
        }
    }

}
