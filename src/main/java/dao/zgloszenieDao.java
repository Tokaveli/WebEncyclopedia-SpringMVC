package dao;

import java.util.List;

import domain.Zgloszenie;



public interface zgloszenieDao {
	Zgloszenie getZgloszenie(long id);
	
	List<Zgloszenie> getAllZgloszenie();	

	void saveOrUpdateZgloszenie(Zgloszenie p);

	void deleteZgloszenie(Zgloszenie p);
}