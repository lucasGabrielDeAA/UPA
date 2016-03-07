package tsi.daw.upa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T>
{
	private final Class<T> classe;
	
	public DAO(Class<T> classe)
	{
		this.classe = classe;
	}
	
	public void add(T t)
	{
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void remove(T t)
	{
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void update(T t)
	{
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<T> getList()
	{
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> list = entityManager.createQuery(query).getResultList();
		entityManager.close();
		
		return list;
	}
	
	public T idSearch(Long id)
	{
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		return (T) entityManager.find(classe, id);
	}

}
