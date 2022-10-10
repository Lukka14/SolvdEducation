package connection.dao.mybatisimpl;

import connection.dao.interfaces.IPetDAO;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Pet;

import java.util.List;

public class PetDAO extends AbstractMySQLDAO implements IPetDAO {

    @Override
    public void create(Pet object) {
        Batis.getSqlSession().insert("Pet.insert",object);
    }

    @Override
    public void remove(Long id) {
        Batis.getSqlSession().delete("Pet.remove",Math.toIntExact(id));
    }

    @Override
    public void update(Pet object) {
        Batis.getSqlSession().update("Pet.update",object);
    }

    @Override
    public List<Pet> getAll() {
        return Batis.getSqlSession().selectList("Pet.getAll");
    }

    @Override
    public Pet getById(Long id) {
        return Batis.getSqlSession().selectOne("Pet.getById", Math.toIntExact(id));
    }

}
