package connection.dao.mybatisimpl;

import connection.Main;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class Batis {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String RESOURCE = "mybatis/mybatis-config.xml";

    public static SqlSession getSqlSession(){
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.warn(e);
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

}
