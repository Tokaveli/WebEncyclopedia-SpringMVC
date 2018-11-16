package dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import domain.Kategoria;
import domain.Zgloszenie;
import domain.pozycja;

public class StaticZgloszenieDao implements zgloszenieDao{

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Zgloszenie getZgloszenie(long id) {
		
		return (Zgloszenie)sessionFactory.getCurrentSession().get(Zgloszenie.class.getName(), id);
	}

	@Override
	public List<Zgloszenie> getAllZgloszenie() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM "+Zgloszenie.class.getName());
		return (List<Zgloszenie>)query.list();
	}

	@Override
	public void saveOrUpdateZgloszenie(Zgloszenie z) {
		sessionFactory.getCurrentSession().saveOrUpdate(z);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void deleteZgloszenie(Zgloszenie z) {
		sessionFactory.getCurrentSession().delete(z);
		sessionFactory.getCurrentSession().flush();
		
	}	
	

	
	

}

