package com.yusufsezer.server.contract;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractService<T> {

    private final Class<T> entityClass;
    private EntityManager em;

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(T entity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Throwable ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void edit(T entity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Throwable ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void remove(T entity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        } catch (Throwable ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        cq.select(cq.from(entityClass));
        TypedQuery<T> q = em.createQuery(cq);
        return q.getResultList();
    }

    public List<T> findRange(int[] range) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        cq.select(cq.from(entityClass));
        TypedQuery<T> q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public Long count() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> from = cq.from(entityClass);
        CriteriaQuery<Long> select = cq.select(cb.count(from));
        TypedQuery<Long> query = em.createQuery(select);
        return query.getSingleResult();
    }

}
