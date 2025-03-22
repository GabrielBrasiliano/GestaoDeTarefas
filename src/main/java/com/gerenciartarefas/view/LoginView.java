package com.gerenciartarefas.view;

import com.gerenciartarefas.utils.FormatComponentsUtil;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Tela de acesso ao sistema.
 * 
 * @author GabrielBrasiliano
 */
public class LoginView extends JFrame {

    private JLabel lbLogin;
    private JTextField txtLogin;
    private JLabel lbSenha;
    private JPasswordField txtSenha;
    private JButton btnAcessar;
    private JButton btnCancelar;
    private GridBagConstraints grid;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Login");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        grid = new GridBagConstraints();

        // Configuração do espaçamento padrão
        lbLogin = new JLabel("Usuário:");
        grid = FormatComponentsUtil.formatGriBagLayout(lbLogin, grid, 0, 0);
        add(lbLogin, grid);

        txtLogin = new JTextField(15);
        grid = FormatComponentsUtil.formatGriBagLayout(txtLogin, grid, 0, 1);
        add(txtLogin, grid);

        // Linha 2 - Label Senha
        lbSenha = new JLabel("Senha:");
        grid = FormatComponentsUtil.formatGriBagLayout(lbSenha, grid, 1, 0);
        add(lbSenha, grid);

        // Linha 2 - Campo Senha
        txtSenha = new JPasswordField(15);
        grid = FormatComponentsUtil.formatGriBagLayout(txtSenha, grid, 1, 1);
        add(txtSenha, grid);

        // Painel de botões (linha 3)
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAcessar = new JButton("Acessar");
        btnCancelar = new JButton("Cancelar");
        panelBotoes.add(btnAcessar);
        panelBotoes.add(btnCancelar);

        grid.gridwidth = 2;
        grid = FormatComponentsUtil.formatGriBagLayout(panelBotoes, grid, 2, 0);
        add(panelBotoes, grid);

        setResizable(false);
    }

    // Métodos para obter os dados
    public String getLogin() {
        return txtLogin.getText().trim();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword()).trim();
    }

    // Métodos para adicionar Listeners aos botões
    public void loginListener(ActionListener listener) {
        btnAcessar.addActionListener(listener);
    }

    public void cancelarListener(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    // Exibir mensagens ao usuário
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
