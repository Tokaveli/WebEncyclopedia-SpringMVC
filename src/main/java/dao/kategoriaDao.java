package dao;

import java.util.List;

import domain.Kategoria;



public interface kategoriaDao {
	Kategoria getKategoria(long id);
	
	List<Kategoria> getAllKategorie();	

	void saveOrUpdateKategoria(Kategoria p);

	void deleteKategoria(Kategoria p);

}
