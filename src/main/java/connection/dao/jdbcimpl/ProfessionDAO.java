package connection.dao.jdbcimpl;

import connection.dao.interfaces.IProfessionDAO;
import connection.dao.connector.ConnectionPool;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Profession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessionDAO extends AbstractMySQLDAO implements IProfessionDAO {

    private static final Logger logger=LogManager.getLogger(ProfessionDAO.class);

    @Override
    public void create(Profession object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("INSERT INTO professions(idprofessions,name,salary) VALUES(?,?,?)");
            ps.setLong(1,object.getId());
            ps.setString(2,object.getName());
            ps.setLong(3,object.getSalary());
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
    public Profession getById(Long id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = ConnectionPool.getInstance().retrieve().prepareStatement("select * from Professions where idprofessions=?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Profession(id,rs.getString("name"),rs.getLong("salary"));
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
            ps =  ConnectionPool.getInstance().retrieve().prepareStatement("DELETE FROM Professions where idProfessions=?");
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
    public void update(Profession object) {
        PreparedStatement ps=null;
        try {
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("update Professions set name=?,salary=? where idProfessions=?");
            ps.setString(1,object.getName());
            ps.setLong(2,object.getSalary());
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
    public List<Profession> getAll(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps= ConnectionPool.getInstance().retrieve().prepareStatement("select COUNT(*) from Professions");
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            List<Profession> pets = new ArrayList<>();
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
