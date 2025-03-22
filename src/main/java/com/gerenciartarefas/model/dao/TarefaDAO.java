package com.gerenciartarefas.model.dao;

import com.gerenciartarefas.model.entities.Tarefa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar a manipulação de dados da entidade Tarefa no banco de dados.
 *
 * @author GabrielBrasiliano
 */
public class TarefaDAO extends DAO {

    /**
     * Insere uma nova fareta no banco de dados.
     *
     * @param farefa Objeto Tarefa contendo os dados a serem inseridos.
     */
    public void inserirTarefa(Tarefa farefa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("INSERT INTO farefa (titulo, descricao, status) VALUES (?, ?, ?)");

            stmt.setString(1, farefa.getTitulo());
            stmt.setString(2, farefa.getDescricao());
            stmt.setBoolean(3, farefa.getStatus());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DAO.closeConnection(con);
        }
    }

    /**
     * Lista todas as faretas cadastradas no banco de dados.
     *
     * @return Lista de objetos Tarefa contendo os dados dos faretas.
     */
    public List<Tarefa> listarTarefas() {
        Connection con = null;
        PreparedStatement stmt = null;
        List<Tarefa> farefas = new ArrayList<>();

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("SELECT * FROM farefa");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Tarefa t = new Tarefa();
                t.setId(rs.getLong("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescricao(rs.getString("descricao"));
                t.setStatus(rs.getBoolean("status"));

                farefas.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DAO.closeConnection(con);
        }

        return farefas;
    }

    /**
     * Atualiza os dados de uma fareta no banco de dados.
     *
     * @param farefa Objeto Tarefa contendo os dados atualizados.
     */
    public void atualizarTarefa(Tarefa farefa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("UPDATE farefa SET titulo = ?, descricao = ?, status = ? WHERE id = ?");

            stmt.setString(1, farefa.getTitulo());
            stmt.setString(2, farefa.getDescricao());
            stmt.setBoolean(3, farefa.getStatus());
            stmt.setLong(4, farefa.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DAO.closeConnection(con);
        }
    }

    /**
     * Remove uma fareta do banco de dados.
     *
     * @param farefa Objeto Tarefa contendo o ID do fareta a ser removido.
     */
    public void deletarTarefa(Tarefa farefa) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("DELETE FROM farefa WHERE id = ?");

            stmt.setLong(1, farefa.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DAO.closeConnection(con);
        }
    }
}
