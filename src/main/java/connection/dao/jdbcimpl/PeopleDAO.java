package connection.dao.jdbcimpl;


import connection.dao.interfaces.IPeopleDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.People;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleDAO extends AbstractMySQLDAO implements IPeopleDAO {

    private static final Logger logger=LogManager.getLogger(PeopleDAO.class);

    @Override
    public void create(People object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO People(idpeople,first_name,last_name,professionsid,carsid,pets_idpets) VALUES(?,?,?,?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getFirstName());
            ps.setString(3,object.getLastName());
            ps.setLong(4,object.getPetId());
            ps.setLong(5,object.getCarId());
            ps.setLong(6,object.getPetId());
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
    public People getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("select * from People where idpeople=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new People(id,rs.getString("first_name"),rs.getString("last_name"),rs.getLong("professionsid"),rs.getLong("carsid"),rs.getLong("pets_idpets"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM People where idpeople=?");
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
    public void update(People object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update People set first_name=?,last_name=?,professionsid=?,carsid=?,pets_idpets=? where idpeople=?");
            ps.setString(1,object.getFirstName());
            ps.setString(2,object.getLastName());
            ps.setLong(3,object.getPetId());
            ps.setLong(4,object.getCarId());
            ps.setLong(5,object.getPetId());
            ps.setLong(6,object.getId());
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
    public List<People> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from People");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<People> pets = new ArrayList<>();
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
