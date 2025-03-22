package com.gerenciartarefas.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar a manipulação de dados da entidade Usuario no banco de dados.
 *
 * @author GabrielBrasiliano
 */
public class DAO {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/gestaodetarefas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao carregar o driver do PostgreSQL", e);
        }
    }

    /**
     * Obtém uma conexão com o banco de dados PostgreSQL.
     *
     * @return Objeto Connection estabelecendo a conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro ao conectar ao banco de dados.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Fecha a conexão com o banco de dados, se estiver aberta.
     *
     * @param con Objeto Connection a ser fechado.
     */
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
