package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDAO<T extends Serializable> {

	private Class<T> clazz;

	@Autowired
	public EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		em = entityManager;
	}

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(Long id) {
		return this.em.find(this.clazz, id);
	}

	public List<T> findAll() {
		return this.em.createQuery("from " + this.clazz.getName())
				.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List<T> findByCriteria(String field, String value) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery cq = criteriaBuilder.createQuery();
		Root e = cq.from(clazz);
		cq.where(criteriaBuilder.like(criteriaBuilder.upper(e.get(field)), "%" + value.toUpperCase() + "%"));
		cq.select(e);
		Query query = em.createQuery(cq);
		
		List<T> ret = query.getResultList();
		
		return ret;
	}

	@Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
	public void save(T entity) {
		this.em.persist(entity);
	}

	@Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
	public void update(T entity) {
		this.em.merge(entity);
	}

	@Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
	public void delete(T entity) {
		this.em.remove(entity);
	}
}