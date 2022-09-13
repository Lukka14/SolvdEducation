package connection.dao.jdbc;

import connection.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class Conn {
    private static final Logger logger = LogManager.getLogger(Main.class);
    /**
     * Create file "datasource.properties" in resources.<p>
     * the file must contain 3 values, path, user </p><p> and password. for example:<p>
     * -----------------------------------------------
     * </p>
     * path=jdbc:mysql://localhost:3306/mydb </p><p>
     * user=root</p><p>
     * password=myPassword123
     *  -----------------------------------------------
     */
    public static Connection getConnection(){
        URL res = Main.class.getClassLoader().getResource("datasource.properties");
        try {
            Properties properties = new Properties();
            properties.load(res.openStream());
            String path = properties.getProperty("path");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            return DriverManager.getConnection(path, user, password);
        } catch (SQLException | IOException | NullPointerException e) {
            logger.error(e);
            e.printStackTrace();
            return null;
        }
    }
}
