package connection.dao.interfaces;

import connection.model.Profession;

import java.util.List;

public interface IProfessionDAO extends IBaseDAO<Profession>{
    List<Profession> getAll();
}
