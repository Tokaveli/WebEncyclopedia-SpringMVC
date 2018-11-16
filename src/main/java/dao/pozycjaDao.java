package dao;

import java.util.ArrayList;
import java.util.List;

import domain.Kategoria;
import domain.pozycja;

public interface pozycjaDao {
	
pozycja getPozycja(long id);
	
List<pozycja> getAllpozycja();

List<Kategoria> getListaKategorii();

void saveOrUpdatePozycja(pozycja p);

void deletePozycja(pozycja p);

}
