/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas.controller;

import gestaodetarefas.dao.UsuarioDAO;
import gestaodetarefas.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author GabrielBrasiliano
 */
public class LogonController {

    private final UsuarioDAO usuarioDAO;

    public LogonController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario validarLogon(String login, String senha) {

        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return null;
        }

        return usuarioDAO.validarAcesso(login, senha);
    }

}
