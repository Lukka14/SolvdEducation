package connection.dao.jdbcimpl;
import connection.dao.interfaces.ICarDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends AbstractMySQLDAO implements ICarDAO {

    private static final Logger logger=LogManager.getLogger(CarDAO.class);

    @Override
    public void create(Car object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO cars(idcars,car_brand,car_model,price,people_id,country_id) VALUES(?,?,?,?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getBrand());
            ps.setString(3,object.getModel());
            ps.setLong(4,object.getPrice());
            ps.setLong(5,object.getPeopleId());
            ps.setLong(6,object.getCountryId());
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
    public Car getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("select * from cars where idcars=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Car(id,rs.getString("car_brand"),rs.getString("car_model"),rs.getLong("price"),rs.getLong("people_id"),rs.getLong("country_id"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM cars where idcars=?");
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
    public void update(Car object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update cars set car_brand=?,car_model=?,price=?,people_id=?,country_id=? where idcars=?");
            ps.setString(1,object.getBrand());
            ps.setString(2,object.getModel());
            ps.setLong(3,object.getPrice());
            ps.setLong(4,object.getPeopleId());
            ps.setLong(5,object.getCountryId());
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
    public List<Car> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from cars");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Car> pets = new ArrayList<>();
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
