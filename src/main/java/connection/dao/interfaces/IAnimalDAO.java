package connection.dao.interfaces;

import connection.model.Animal;

import java.util.List;

public interface IAnimalDAO extends IBaseDAO<Animal>{
    List<Animal> getAll();
}
