package group02.lukaswais.shopping_cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB connection to MySQL database with a Singleton.
 *
 * @author Lukas Wais
 */
public class DBConnection {
    // not sure about the url...
    private static final String DB_URL = "jdbc:mysql://10.8.11.20:3306";
    private static DBConnection instance;
    private Connection connection;

    public DBConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(DB_URL, "root", "password");
        } catch (SQLException e) {
            System.out.println("Could not connect to the database" + e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            try {
                instance = new DBConnection();
            } catch (SQLException throwables) {
                System.out.println("Can not establish database connection \n" + throwables.getMessage());
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
