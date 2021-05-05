package ru;
import ru.database.Manager.ClientManager;
import ru.ui.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Application {
    private static Application instance;
    private final ClientManager clientManager = new ClientManager();
    public static void main(String[] args) {
        new Application();
    }
    private Application() {
        instance = this;
        new LoginForm();
    }
    public static Application getInstance() {
        return instance;
    }
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/demoex?serverTimeZone=UTC&characterEncoding=utf8",
                "root",
                "1234"
        );
    }
    public ClientManager getClientManager() {
        return clientManager;
    }
}
