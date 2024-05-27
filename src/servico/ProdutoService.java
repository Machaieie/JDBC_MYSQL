package servico;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    // Método para adicionar um produto ao banco de dados
    public boolean adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produto (codigo, nome, descricao, venda, custo, quantest) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getVenda());
            stmt.setDouble(5, produto.getCusto());
            stmt.setInt(6, produto.getQuantest());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar um produto pelo código
    public Produto buscarProduto(int codigo) {
        String sql = "SELECT * FROM produto WHERE codigo = ?";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setVenda(rs.getDouble("venda"));
                produto.setCusto(rs.getDouble("custo"));
                produto.setQuantest(rs.getInt("quantest"));
                return produto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para atualizar um produto
    public boolean atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, venda = ?, custo = ?, quantest = ? WHERE codigo = ?";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getVenda());
            stmt.setDouble(4, produto.getCusto());
            stmt.setInt(5, produto.getQuantest());
            stmt.setInt(6, produto.getCodigo());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para deletar um produto pelo código
    public boolean deletarProduto(int codigo) {
        String sql = "DELETE FROM produto WHERE codigo = ?";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para listar todos os produtos
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setVenda(rs.getDouble("venda"));
                produto.setCusto(rs.getDouble("custo"));
                produto.setQuantest(rs.getInt("quantest"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
