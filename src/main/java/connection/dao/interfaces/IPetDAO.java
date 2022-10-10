package connection.dao.interfaces;

import connection.model.Pet;

import java.util.List;

public interface IPetDAO extends IBaseDAO<Pet>{
    List<Pet> getAll();
}
