/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciartarefas.utils;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;

/**
 * Classe utils para componentes graficos do swing.
 * 
 * @author GabrielBrasiliano
 */
public class FormatComponentsUtil {

    public static GridBagConstraints formatGriBagLayout(Component componente, GridBagConstraints grade, int linha, int coluna) {

        grade.insets = new Insets(4, 4, 4, 4);
        grade.gridx = coluna;
        grade.gridy = linha;

        if (JLabel.class.isInstance(componente)) {
            grade.fill = GridBagConstraints.NONE; //preenchimento
            grade.weightx = 0; //horizontal
            grade.weighty = 0; //vertical

        } else if (JTextField.class.isInstance(componente)) {
            grade.fill = GridBagConstraints.HORIZONTAL; //preenchimento
            grade.weightx = 1; //horizontal
            grade.weighty = 0; //vertical

        } else if (JPanel.class.isInstance(componente)) {
            grade.fill = GridBagConstraints.HORIZONTAL; //preenchimento
            grade.weightx = 1; //horizontal
            grade.weighty = 0; //vertical            

        }

        return grade;
    }

}
