package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Kategoria;
import domain.pozycja;

public class StaticPozycjaDao implements pozycjaDao {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;
	

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	
	
	
	
	
	
	@Override
	public pozycja getPozycja(long id) {
		
		return (pozycja)sessionFactory.getCurrentSession().get(pozycja.class.getName(), id);
	}

	
	@Override
	public List<pozycja> getAllpozycja() {	
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM "+pozycja.class.getName());
		return sortowanie((List<pozycja>)query.list());

		
	}


	@Override
	public List<Kategoria> getListaKategorii() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM "+Kategoria.class.getName());
		return (List<Kategoria>)query.list();	
	}


	@Override
	public void saveOrUpdatePozycja(pozycja p) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(p);
		sessionFactory.getCurrentSession().flush();

	}


	@Override
	public void deletePozycja(pozycja p) {
		sessionFactory.getCurrentSession().delete(p);
		sessionFactory.getCurrentSession().flush();
		
	}
	 public static List<pozycja> sortowanie(List<pozycja> doSortowania)
	    {
	        for(int i=0;i<doSortowania.size()-1;i++)
	            for(int j=i+1;j<doSortowania.size();j++)
	            {
	                if(doSortowania.get(i).getNazwa().compareToIgnoreCase((doSortowania.get(j).getNazwa()))>0)
	                {
	                    pozycja a=doSortowania.get(j);
	                    doSortowania.remove(j);
	                    doSortowania.add(i, a);
	                }
	            }
	        return doSortowania;
	    }
	
}
