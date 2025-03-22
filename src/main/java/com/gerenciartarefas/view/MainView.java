/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.view;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * Tela principal do sistema.
 * 
 * @author GabrielBrasiliano
 */
public class MainView extends JFrame {

    private JTree arvoreCategorias;
    private JPanel painelPrincipal;
    private JScrollPane scrollPaneArvore;

    public MainView() {

        setTitle("Gerenciador de Tarefas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 🔹 Tela cheia
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        arvoreCategorias = new JTree();
        scrollPaneArvore = new JScrollPane(arvoreCategorias);

        painelPrincipal = new JPanel();
        painelPrincipal.setBackground(Color.WHITE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneArvore, painelPrincipal);
        splitPane.setDividerLocation(200); // Define o tamanho inicial da JTree
        splitPane.setOneTouchExpandable(true); // Permite expandir/recolher

        add(splitPane, BorderLayout.CENTER);
    }

    public void atualizarArvore(DefaultTreeModel modelo) {
        arvoreCategorias.setModel(modelo);
    }

    // Exibir mensagens ao usuário
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView lv = new MainView();
            lv.setVisible(true);
        });
    }
}
