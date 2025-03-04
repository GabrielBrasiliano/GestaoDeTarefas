/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaodetarefas.dao;

/**
 *
 * @author GabrielBrasiliano
 */
public class ExceptionDAO extends Exception {

    // Construtor padrão
    public ExceptionDAO() {
        super("Erro de acesso ao banco de dados.");
    }

    // Construtor que aceita uma mensagem personalizada
    public ExceptionDAO(String mensagem) {
        super(mensagem);
    }

    // Construtor que aceita uma mensagem e a causa do erro (SQLException, por exemplo)
    public ExceptionDAO(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    // Construtor que aceita apenas a causa
    public ExceptionDAO(Throwable causa) {
        super(causa);
    }
}
