package connection.dao.mybatisimpl;

import connection.dao.interfaces.IPeopleDAO;
import connection.dao.mysql.AbstractMySQLDAO;
import connection.model.People;

import java.util.List;

public class PeopleDAO extends AbstractMySQLDAO implements IPeopleDAO {

    @Override
    public void create(People object) {
        Batis.getSqlSession().insert("People.insert",object);
    }

    @Override
    public void remove(Long id) {
        Batis.getSqlSession().delete("People.remove",Math.toIntExact(id));
    }

    @Override
    public void update(People object) {
        Batis.getSqlSession().update("People.update",object);
    }

    @Override
    public List<People> getAll() {
        return Batis.getSqlSession().selectList("People.getAll");
    }

    @Override
    public People getById(Long id) {
        return Batis.getSqlSession().selectOne("People.getById", Math.toIntExact(id));
    }

}
