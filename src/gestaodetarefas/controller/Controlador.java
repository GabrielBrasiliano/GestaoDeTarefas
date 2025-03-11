/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas.controller;

import gestaodetarefas.model.entities.Tarefa;
import gestaodetarefas.view.MainView;
import java.util.List;

/**
 *
 * @author Ceres
 */
public class Controlador {

    private MainView view;
    private List<Tarefa> model;

    public Controlador(MainView view, List<Tarefa> model) {
        this.view = view;
        this.model = model;
    }

}
