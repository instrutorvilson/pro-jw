package interfaces;

import java.util.List;

public interface CRUD<T> {
   T salvar(T obj);
   T update(T obj);
   void delete(int id);
   T getById(int id);
   List<T> getAll();
}
