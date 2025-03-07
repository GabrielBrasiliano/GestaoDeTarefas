/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas;

import gestaodetarefas.view.LogonView;
import gestaodetarefas.view.MainView;
import javax.swing.SwingUtilities;

/**
 *
 * @author GabrielBrasiliano
 */
public class Main {

    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> {
            LogonView login = new LogonView(null);
            login.setVisible(true);

            if (login.isAutenticado()) {
                new MainView(login.getUsuario());
            }
        });
    }
}
