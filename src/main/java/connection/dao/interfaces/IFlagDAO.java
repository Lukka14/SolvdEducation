package connection.dao.interfaces;

import connection.model.Flag;

import java.util.List;

public interface IFlagDAO extends IBaseDAO<Flag>{
    List<Flag> getAll();
}
