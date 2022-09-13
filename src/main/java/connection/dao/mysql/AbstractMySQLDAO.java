package connection.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractMySQLDAO {
    private static final Logger logger = LogManager.getLogger(AbstractMySQLDAO.class);
    void createClass() {
        try {
            Class c1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e){
            logger.error(e.getMessage());
        }
    }
}
