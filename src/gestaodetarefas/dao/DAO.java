/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodetarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GabrielBrasiliano
 */
public class DAO {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/gestaodetarefas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static Connection connection;

    // Construtor privado para evitar instâncias diretas
    private DAO() {}

    // Método para obter a conexão única (Singleton)
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão estabelecida com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            }
        }
        return connection;
    }

    // Método para fechar a conexão (boa prática)
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
