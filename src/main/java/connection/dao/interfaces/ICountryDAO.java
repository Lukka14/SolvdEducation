package connection.dao.interfaces;

import connection.model.Country;

import java.util.List;

public interface ICountryDAO extends IBaseDAO<Country>{
    List<Country> getAll();
}
