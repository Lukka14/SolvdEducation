package connection.dao.interfaces;

import connection.model.People;

import java.util.List;

public interface IPeopleDAO extends IBaseDAO<People>{
    List<People> getAll();
}
