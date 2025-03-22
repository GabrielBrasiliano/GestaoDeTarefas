package com.gerenciartarefas.model.dao;

import com.gerenciartarefas.model.entities.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar a manipulação de dados da entidade Categoria no banco de dados.
 *
 * @author GabrielBrasiliano
 */
public class CategoriaDAO extends DAO {

    /**
     * Insere um novo objeto Categoria no banco de dados.
     *
     * @param categoria O objeto Categoria a ser inserido.
     * @return Retorna true se a inserção foi bem-sucedida, false caso contrário.
     */
    public boolean insert(Categoria categoria) {
        boolean result = false;

        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("INSERT INTO categoria (nome, usuario_id) VALUES (?, ?)");

            stmt.setString(1, categoria.getNome());
            stmt.setLong(2, categoria.getUsuario_id());

            stmt.executeUpdate();
            result = true;

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
            DAO.closeConnection(conexao);
        }

        return result;
    }

    public List<Categoria> select(String colunas, String where, String orderBy) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        List<Categoria> categorias = new ArrayList<>();
        try {
            if (orderBy.equals("")) {
                orderBy = " nome asc ";
            }

            if (where.equals("")) {
                where = " 1 = 1 ";
            }

            if (colunas.equals("")) {
                colunas = " * ";
            }

            String query = "SELECT " + colunas + " FROM categoria  WHERE " + where + " ORDER BY " + orderBy;

            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria u = new Categoria();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setUsuario_id(rs.getLong("usuario_id"));

                categorias.add(u);
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
            DAO.closeConnection(conexao);
        }

        return categorias;
    }

    /**
     * Atualiza os dados de um categoria no banco de dados.
     *
     * @param categoria Objeto Categoria contendo os dados atualizados.
     */
    public void atualizarCategoria(Categoria categoria) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("UPDATE categoria SET nome = ? WHERE id = ?");

            stmt.setString(1, categoria.getNome());
            stmt.setLong(2, categoria.getId());

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
            DAO.closeConnection(conexao);
        }
    }

    /**
     * Remove um categoria do banco de dados.
     *
     * @param categoria Objeto Categoria contendo o ID do categoria a ser removido.
     */
    public void deletarCategoria(Categoria categoria) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("DELETE FROM categoria WHERE id = ?");
            stmt.setLong(1, categoria.getId());
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
            DAO.closeConnection(conexao);
        }
    }
}
