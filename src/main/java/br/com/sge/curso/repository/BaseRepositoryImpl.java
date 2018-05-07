package br.com.sge.curso.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.BaseModel;

@Transactional
public class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> persistenceClass;
	
	public BaseRepositoryImpl(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}
	
	@Override
	public Iterable<T> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<T> findAll(Pageable arg0) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(persistenceClass.getClass());
		return (Page<T>) criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(T arg0) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(arg0);
		session.flush();
	}

	@Override
	@Transactional
	public void delete(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(persistenceClass);
		criteria.addOrder(Order.asc("id"));
		return (Iterable<T>) criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public T findOne(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(persistenceClass, id);
	}

	@Override
	@Transactional
	public T save(T arg0) {
		Session session = sessionFactory.getCurrentSession();
		session.save(arg0);
		session.flush();
		return arg0;
	}

	@Override
	@Transactional
	public Iterable<T> save(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public T update(T arg0) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(arg0);
		session.flush();
		return arg0;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
