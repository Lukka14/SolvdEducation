package connection.dao.jdbcimpl;


import connection.dao.interfaces.IFlagDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Flag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlagDAO extends AbstractMySQLDAO implements IFlagDAO {

    private static final Logger logger=LogManager.getLogger(FlagDAO.class);

    @Override
    public void create(Flag object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO flags(idflags,color,name) VALUES(?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setString(3,object.getColor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        } finally{
            try {
                ps.close();
            } catch (SQLException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public Flag getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("select * from flags where idflags=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Flag(id,rs.getString("color"),rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        return null;
    }

    @Override
    public void remove(Long id) {
        PreparedStatement ps = null;
        try {
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM flags where idflags=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error(e);
        }finally {
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }

    }

    @Override
    public void update(Flag object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update flags set color=?,name=? where idflags=?");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getColor());
            ps.setString(3,object.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn(e);
        }finally {
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }
    }

    @Override
    public List<Flag> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from flags");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Flag> pets = new ArrayList<>();
            for(long i = 1L; i<=count; i++){
                pets.add(getById(i));
            }
            return pets;
        }catch (SQLException e){
            e.printStackTrace();
            logger.warn(e);
        }finally {
            try{
                rs.close();
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.warn(e);
            }
        }
        return null;
    }

}
