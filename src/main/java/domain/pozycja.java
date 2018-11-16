package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name = "pozycje")

public class pozycja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	@NotBlank
	@Size(min=2, max=30, message="Ilosc znakow nazwy musi byc z przedzialu 2-30 znakow")
	@Column(name = "nazwa", nullable = false) 
	private String nazwa;
	@NotBlank
	@Column(name = "informacja", nullable = false)
	private String informacje;
	
	@Column(name = "komentarze", nullable = false)
	private String komentarze="";
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="kategoria_id", nullable = false)

	private Kategoria dodatkoweDane;
	
	public pozycja() {
		dodatkoweDane=new Kategoria();		
	}
	@Autowired
	public pozycja(long ID,String nazwa, String informacje, Kategoria kategoria) {
		dodatkoweDane=kategoria;
		this.ID=ID;
		this.nazwa = nazwa;
		this.informacje = informacje;
		
		
	}
	
	

	public long getID(){
		return ID;
	}
	
	public void setID(long ID){
		this.ID=ID;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getInformacje() {
		return informacje;
	}
	public void setInformacje(String informacje) {
		this.informacje = informacje;
	}
	
	public Kategoria getDodatkoweDane() {
		return dodatkoweDane;
	}
	public void setDodatkoweDane(Kategoria dodatkoweDane) {
		this.dodatkoweDane = dodatkoweDane;
	}
	
	public void setKomentarze(String kom)
	{
		this.komentarze=kom;
	}
	
	public String getKomentarze()
	{
		return komentarze;
	}
	
	
	
	
	

}
