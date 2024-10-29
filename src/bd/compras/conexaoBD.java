package bd.compras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/desafio";
    private static final String USER = "root";
    private static final String PASSWORD = "Root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
