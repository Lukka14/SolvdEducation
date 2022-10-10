package connection.dao.jdbcimpl;

import connection.dao.interfaces.IPetDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Pet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends AbstractMySQLDAO implements IPetDAO {
    private static final Logger logger= LogManager.getLogger(AnimalDAO.class);

    @Override
    public void create(Pet object) {
        PreparedStatement ps=null;
        try {
            ps=  ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO pets(idpets,name,animalsid) VALUES(?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setLong(3,object.getAnimalId());
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
    public Pet getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("select * from pets where idpets=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Pet(id,rs.getString("name"),rs.getLong("animalsid"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM pets where idpets=?");
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
    public void update(Pet object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update pets set animalsid=?,name=? where idpets=?");
            ps.setLong(1,object.getAnimalId());
            ps.setString(2,object.getName());
            ps.setLong(3,object.getId());
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
    public List<Pet> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from pets");
            rs = ps.executeQuery();;
            rs.next();
            int count = rs.getInt(1);
            List<Pet> pets = new ArrayList<>();
            for(Long i=1L;i<=count;i++){
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
