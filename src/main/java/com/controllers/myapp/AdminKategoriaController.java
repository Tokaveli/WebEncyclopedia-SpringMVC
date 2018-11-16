package com.controllers.myapp;

import java.awt.List;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.StaticPozycjaDao;
import dao.kategoriaDao;
import dao.pozycjaDao;
import domain.Kategoria;
import domain.pozycja;



/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value={"listaPozycji"})
public class AdminKategoriaController {
	
	
	@Autowired
	kategoriaDao dao2;
	
	@Autowired
	pozycjaDao dao3;
	
	

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	//*************KATEGORIE***************************************************
	
	@RequestMapping(value = "/AdminKategorieWszystkie.html", method= RequestMethod.GET)
	public String wszystkieKategorie(ModelMap model) throws Exception
	{		
		model.addAttribute("listaKategorii", dao2.getAllKategorie());		
		return "AdminKategorieWszystkie";		
	}
	
	@RequestMapping(value = "/AdminKategoriaDodawanieEdycja.html", method= RequestMethod.GET)
	public String DodawanieEdycjaKategorii(Model model, @RequestParam(value="id", defaultValue="-1") Long id)
	{
		if(id==-1)
				{
					Kategoria k=new Kategoria();				
					model.addAttribute("kategoria",k);
					return "dodawanieKategorii";
				}
			else
			{			
				model.addAttribute("kategoria", dao2.getKategoria(id));
				return "AdminDodawanieKategorii";
			}
	}
	
	@RequestMapping(value="/AdminKategoriaDodawanieEdycja.html", method = RequestMethod.POST)
	public String DodawanieEdycjaKategorii(Model model,@ModelAttribute("kategoria") @Valid  Kategoria kategoria,BindingResult result) throws Exception 
{		
		if(result.hasErrors())
			return "AdminDodawanieKategorii";			
		else
		{					
				dao2.saveOrUpdateKategoria(kategoria);
				model.addAttribute("listaKategorii",dao2.getAllKategorie());	
				return "AdminKategorieWszystkie";//"successView";
		}
}
	
	@RequestMapping(value = "/AdminUsuwanieKategorii.html", method= RequestMethod.GET)
	public String usunKategorie(Model model, @RequestParam(value="did") int did)
	{
		if(dao2.getKategoria(did).getNazwa().equals("Brak"))
		{
			
		}
		else
		{
		        ArrayList<pozycja> pozycje=(ArrayList<pozycja>)dao3.getAllpozycja();
		        ArrayList<Kategoria>kategorie=(ArrayList<Kategoria>)dao2.getAllKategorie();
		        Kategoria k=null;
		        for (int i=0;i<kategorie.size();i++)
		        {
		        	if(kategorie.get(i).getNazwa().equals("Brak"))
		        		k=kategorie.get(i);
		        }
		        for(int i=0;i<pozycje.size();i++)
		        {
		        	if(pozycje.get(i).getDodatkoweDane().getID()==did)
		        	{
		        		pozycja p=pozycje.get(i);
	        			
		        		if(k!=null)
		        		{
		        			
		        			p.setDodatkoweDane(k);
		        		}
		        		else
		        		{
		        			k=new Kategoria("Brak");
		        			dao2.saveOrUpdateKategoria(k);
		        			p.setDodatkoweDane(k);
		        			dao3.saveOrUpdatePozycja(p);
		        			
		        		}
		        	}
		        }
		        
				dao2.deleteKategoria(dao2.getKategoria(did));
				model.addAttribute("listaKategorii",dao2.getAllKategorie());				
		}
				return "AdminKategorieWszystkie";
	}
	
	
		
		
		
	
	
	
	
}
