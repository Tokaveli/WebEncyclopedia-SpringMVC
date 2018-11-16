package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import domain.Kategoria;
import domain.pozycja;

public class StaticKategoriaDao implements kategoriaDao{

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	@Override
	public Kategoria getKategoria(long id) {
		return (Kategoria)sessionFactory.getCurrentSession().get(Kategoria.class.getName(), id);
		
	}

	@Override
	public List<Kategoria> getAllKategorie() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM "+Kategoria.class.getName());
		return sortowanie((List<Kategoria>)query.list());
	}

	
	

	@Override
	public void saveOrUpdateKategoria(Kategoria k) {
		sessionFactory.getCurrentSession().saveOrUpdate(k);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void deleteKategoria(Kategoria k) {
		sessionFactory.getCurrentSession().delete(k);
		sessionFactory.getCurrentSession().flush();
		
	}
	
	 public static List<Kategoria> sortowanie(List<Kategoria> doSortowania)
	    {
	        for(int i=0;i<doSortowania.size()-1;i++)
	            for(int j=i+1;j<doSortowania.size();j++)
	            {
	                if(doSortowania.get(i).getNazwa().compareToIgnoreCase((doSortowania.get(j).getNazwa()))>0)
	                {
	                    Kategoria a=doSortowania.get(j);
	                    doSortowania.remove(j);
	                    doSortowania.add(i, a);
	                }
	            }
	        return doSortowania;
	    }

}
