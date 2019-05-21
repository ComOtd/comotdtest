package dao;

import java.util.List;

public interface GenericDao<E,K> {
    /** Сохранить объект newInstance в базе данных */
    void save(E object);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа.
     */
    E get(K id);

    /** Извлечь объектs, предварительно сохраненныt в базе данных. */
    List<E> getAll();

    /** Сохранить изменения, сделанные в объекте.  */
    void update(E object);

    /** Удалить объект из базы данных. */
    void delete(E object);
}
