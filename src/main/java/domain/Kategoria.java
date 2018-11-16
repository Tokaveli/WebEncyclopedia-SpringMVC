package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kategorie")
public class Kategoria {
	

	@Column(name = "informacja", nullable = false)
	String nazwa;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long ID;
	
	public Kategoria()
	{
		
	}
	
	public Kategoria(long id, String nazwa)
	{
		this.nazwa=nazwa;
		this.ID=id;
	}
	
	public Kategoria(String nazwa)
	{
		this.nazwa=nazwa;
		
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

}
