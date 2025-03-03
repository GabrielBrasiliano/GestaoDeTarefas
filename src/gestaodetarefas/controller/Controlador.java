/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas.controller;

import gestaodetarefas.model.Tarefa;
import gestaodetarefas.view.MainFrame;
import java.util.List;

/**
 *
 * @author Ceres
 */
public class Controlador {

    private MainFrame view;
    private List<Tarefa> model;

    public Controlador(MainFrame view, List<Tarefa> model) {
        this.view = view;
        this.model = model;
    }

}
