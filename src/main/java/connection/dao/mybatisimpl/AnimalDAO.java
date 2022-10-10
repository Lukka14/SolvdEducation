package connection.dao.mybatisimpl;

import connection.dao.interfaces.IAnimalDAO;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.Animal;

import java.util.List;

public class AnimalDAO extends AbstractMySQLDAO implements IAnimalDAO {

    @Override
    public void create(Animal object) {
        Batis.getSqlSession().insert("Animal.insert",object);
    }

    @Override
    public void remove(Long id) {
        Batis.getSqlSession().delete("Animal.remove",Math.toIntExact(id));
    }

    @Override
    public void update(Animal object) {
        Batis.getSqlSession().update("Animal.update",object);
    }

    @Override
    public List<Animal> getAll() {
        return Batis.getSqlSession().selectList("Animal.getAll");
    }

    @Override
    public Animal getById(Long id) {
        return Batis.getSqlSession().selectOne("Animal.getById", Math.toIntExact(id));
    }

}
