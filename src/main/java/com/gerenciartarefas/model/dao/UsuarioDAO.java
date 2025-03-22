package com.gerenciartarefas.model.dao;

import com.gerenciartarefas.model.entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar a manipulação de dados da entidade Usuario no banco de dados.
 *
 * @author GabrielBrasiliano
 */
public class UsuarioDAO extends DAO {

    /**
     * Insere um novo usuário no banco de dados.
     *
     * @param usuario Objeto Usuario contendo os dados a serem inseridos.
     */
    public void inserirUsuario(Usuario usuario) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, fone, login, senha) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getFone());
            stmt.setString(4, usuario.getLogin());
            stmt.setString(5, usuario.getSenha());

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

    public Usuario validarAcesso(String login, String senha) {
        Connection conexao = null;
        Usuario usuario = null;
        PreparedStatement stmt = null;
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFone(rs.getString("fone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
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

        return usuario;
    }

    /**
     * Lista todos os usuários cadastrados no banco de dados.
     *
     * @return Lista de objetos Usuario contendo os dados dos usuários.
     */
    public List<Usuario> listarUsuarios() {
        Connection conexao = null;
        PreparedStatement stmt = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setFone(rs.getString("fone"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                usuarios.add(u);
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

        return usuarios;
    }

    /**
     * Atualiza os dados de um usuário no banco de dados.
     *
     * @param usuario Objeto Usuario contendo os dados atualizados.
     */
    public void atualizarUsuario(Usuario usuario) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, fone = ?, login = ?, senha = ? WHERE id = ?");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getFone());
            stmt.setString(4, usuario.getLogin());
            stmt.setString(5, usuario.getSenha());
            stmt.setLong(6, usuario.getId());

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
     * Remove um usuário do banco de dados.
     *
     * @param usuario Objeto Usuario contendo o ID do usuário a ser removido.
     */
    public void deletarUsuario(Usuario usuario) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        try {
            conexao = DAO.getConnection();
            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setLong(1, usuario.getId());
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
