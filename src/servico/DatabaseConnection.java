package servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private static final String STRING_DE_CONEXAO = "jdbc:mysql://localhost:3306/tarefa";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(STRING_DE_CONEXAO, USUARIO, SENHA);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o BD: " + e.getMessage());
        }
        return conexao;
    }
}
