/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas;

import gestaodetarefas.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ceres
 */
public class Main {

    public static void main(String args[]) {
        MainFrame menu = null;

        try {
            menu = MainFrame.getInstance();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage() + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        menu.setVisible(true);
    }
}
