package connection.dao.jdbcimpl;


import connection.dao.interfaces.ICountryDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Country;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends AbstractMySQLDAO implements ICountryDAO {

    private static final Logger logger=LogManager.getLogger(CountryDAO.class);

    @Override
    public void create(Country object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO country(idcountry,name,location,flagsid) VALUES(?,?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setString(3,object.getLocation() );
            ps.setLong(3,object.getFlagId());
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
    public Country getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("select * from country where idcountry=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Country(id,rs.getString("name"),rs.getString("location"),rs.getLong("flagsid"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM country where idcountry=?");
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
    public void update(Country object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update country set name=?,location=?,flagsid=? where idcountry=?");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setString(3,object.getLocation());
            ps.setLong(4,object.getFlagId());
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
    public List<Country> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from country");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Country> pets = new ArrayList<>();
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
