package connection.dao.jdbc;

import connection.dao.IAnimalDAO;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Animal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends AbstractMySQLDAO implements IAnimalDAO {

    private static final Logger logger=LogManager.getLogger(AnimalDAO.class);

    @Override
    public void create(Animal object) {
        PreparedStatement ps=null;
        try {
            ps=Conn.getConnection().prepareStatement("INSERT INTO animals(idpets,animal_type,weight) VALUES(?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getType());
            ps.setFloat(3,object.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        } finally{
            try {
                ps.close();
                Conn.getConnection().close();
            } catch (SQLException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public Animal getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = Conn.getConnection().prepareStatement("select * from animals where idpets=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Animal(id,rs.getString("animal_type"),rs.getFloat("weight"));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }finally {
            try {
                rs.close();
                ps.close();
                Conn.getConnection().close();
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
            ps = Conn.getConnection().prepareStatement("DELETE FROM animals where idpets=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error(e);
        }finally {
            try{
                ps.close();
                Conn.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }

    }

    @Override
    public void update(Animal object) {
        PreparedStatement ps=null;
        try {
            ps=Conn.getConnection().prepareStatement("update animals set animal_type=?,weight=? where idpets=?");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getType());
            ps.setFloat(3,object.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn(e);
        }finally {
            try{
                ps.close();
                Conn.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.error(e);
            }
        }
    }

    @Override
    public List<Animal> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=Conn.getConnection().prepareStatement("select COUNT(*) from animals");
            rs = ps.executeQuery();;
            rs.next();
            int count = rs.getInt(1);
            List<Animal> pets = new ArrayList<>();
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
                Conn.getConnection().close();
            }catch (SQLException e){
                e.printStackTrace();
                logger.warn(e);
            }
        }
        return null;
    }

}
