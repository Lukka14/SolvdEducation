package connection.dao.interfaces;

import connection.model.Car;

import java.util.List;

public interface ICarDAO extends IBaseDAO<Car>{
    List<Car> getAll();
}
