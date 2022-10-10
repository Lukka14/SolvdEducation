package connection.dao.interfaces;

public interface IBaseDAO<T> {
    void create(T object);
    T getById(Long id);
    void remove(Long id);
    void update(T object);
}
