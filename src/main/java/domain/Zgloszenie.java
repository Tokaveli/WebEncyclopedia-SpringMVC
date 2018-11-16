package domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name = "zgloszenia")
public class Zgloszenie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank	
	@Column(name = "nazwahasla", nullable = false)
	private String nazwaHasla;
	
	@Column(name = "idzglaszanegohasla", nullable = false)
	private long idZglaszanegoHasla;
	
	@NotBlank
	@Column(name = "tresc", nullable = false)
	private String trescZgloszenia;
	
	@Column(name = "dataZgloszenia", nullable = false)
	private Date dataZgloszenia;
	
	

	public Zgloszenie ()
	{
	dataZgloszenia=new Date();
	}
	
	public long getId() {
		return id;
	}
	public String getNazwaHasla() {
		return nazwaHasla;
	}


	public void setNazwaHasla(String nazwaHasla) {
		this.nazwaHasla = nazwaHasla;
	}





	public long getIdZglaszanegoHasla() {
		return idZglaszanegoHasla;
	}


	public void setIdZglaszanegoHasla(long idZglaszanegoHasla) {
		this.idZglaszanegoHasla = idZglaszanegoHasla;
	}


	public String getTrescZgloszenia() {
		return trescZgloszenia;
	}


	public void setTrescZgloszenia(String trescZgloszenia) {
		this.trescZgloszenia = trescZgloszenia;
	}

	public Date getDataZgloszenia() {
		return dataZgloszenia;
	}

	public void setDataZgloszenia(Date dataZgloszenia) {
		this.dataZgloszenia = dataZgloszenia;
	}

	


	
}
