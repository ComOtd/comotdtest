package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import bl.HibernateUtil;

public class GenericDaoHibernateImpl<E, K> implements GenericDao <E, K> {
    protected EntityManager entityManager = HibernateUtil.getEm();
    protected Class<E> entityClass;

    public GenericDaoHibernateImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(E object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    @Override
    public E get(K id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> getAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM " + entityClass.getSimpleName());
        return query.getResultList();
    }

    @Override
    public void update(E object) {
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(E object) {
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
}
