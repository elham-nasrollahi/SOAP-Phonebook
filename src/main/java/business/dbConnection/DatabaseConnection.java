package business.dbConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Elham on 3/18/2020.
 */
public class DatabaseConnection{
    private String databaseDriver;
    private String databaseConnectionUrl;
    private String databaseUsername;
    private String databasePassword;

    private Connection connection;

    private DatabaseConnection(){}
    private static DatabaseConnection databaseConnection = null;

    public Connection getConnection() {

        databaseDriver = "oracle.jdbc.driver.OracleDriver";
        databaseConnectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        databaseUsername = "SYSTEM";
        databasePassword = "eli";

        try {
            Class.forName(databaseDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    databaseConnectionUrl,databaseUsername,databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static synchronized DatabaseConnection getNewInstance(){
        if (databaseConnection==null){
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }
}

