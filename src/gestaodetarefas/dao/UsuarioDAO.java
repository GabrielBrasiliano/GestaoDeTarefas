package gestaodetarefas.dao;

import gestaodetarefas.model.Usuario;
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
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("INSERT INTO usuario (nome, email, fone) VALUES (?, ?, ?)");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getFone());

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
     * Lista todos os usuários cadastrados no banco de dados.
     * 
     * @return Lista de objetos Usuario contendo os dados dos usuários.
     */
    public List<Usuario> listarUsuarios() {
        Connection con = null;
        PreparedStatement stmt = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setFone(rs.getString("fone"));

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
            DAO.closeConnection(con);
        }

        return usuarios;
    }

    /**
     * Atualiza os dados de um usuário no banco de dados.
     * 
     * @param usuario Objeto Usuario contendo os dados atualizados.
     */
    public void atualizarUsuario(Usuario usuario) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("UPDATE usuario SET nome = ?, email = ? WHERE id = ?");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setLong(3, usuario.getId());

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
     * Remove um usuário do banco de dados.
     * 
     * @param usuario Objeto Usuario contendo o ID do usuário a ser removido.
     */
    public void deletarUsuario(Usuario usuario) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DAO.getConnection();
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");

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
            DAO.closeConnection(con);
        }
    }
}