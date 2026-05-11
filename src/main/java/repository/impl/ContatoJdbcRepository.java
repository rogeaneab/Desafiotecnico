package repository.impl;

import database.DatabaseConnection;
import model.Contato;
import repository.ContatoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoJdbcRepository implements ContatoRepository {

    @Override
    public void salvar(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email, categoria, data_cadastro) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.setString(4, contato.getCategoria());
            stmt.setString(5, contato.getDataCadastro().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato: " + e.getMessage());
        }
    }

    @Override
    public List<Contato> listarTodos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setCategoria(rs.getString("categoria"));
                contatos.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }

    @Override
    public void atualizar(Contato contato) {
        String sql = "UPDATE contatos SET nome=?, telefone=?, email=?, categoria=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.setString(4, contato.getCategoria());
            stmt.setLong(5, contato.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar: " + e.getMessage());
        }
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM contatos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir: " + e.getMessage());
        }
    }

    @Override
    public Contato buscarPorId(Long id) {
        return listarTodos().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}