package com.controllers.myapp;

import java.awt.List;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
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
public class AdminPozycjaController {
	
	
	@Autowired
	pozycjaDao dao;
	@Autowired
	kategoriaDao dao2;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin.html", method= RequestMethod.GET)
	public String admin(ModelMap model) throws Exception
	{		
		model.addAttribute("listaPozycji", dao.getAllpozycja());		
		return "admin";		
	}
	
	@RequestMapping(value = "/AdminPozycjaJedna.html", method= RequestMethod.GET ,params={"id"})
	public String pozycjaJedna(Model model, @RequestParam("id") long id) 
	{	
				model.addAttribute("poz", dao.getPozycja(id));	
		return "AdminPozycjaJedna";
	}
	
	@RequestMapping(value = "/AdminPozycjeWszystkie.html", method= RequestMethod.GET)
	public String wszystkiePozycje(ModelMap model) throws Exception
	{		
		model.addAttribute("listaPozycji", dao.getAllpozycja());		
		return "AdminPozycjeWszystkie";		
	}
	
	@RequestMapping(value = "/AdminPozycjeWszystkie.html", method= RequestMethod.GET ,params={"id"})
	public String wyswietlPozycjeOID(Model model, @RequestParam("id") long id) 
	{	
				model.addAttribute("poz", dao.getPozycja(id));	
		return "AdminPozycjaJedna";
	}
	
	@RequestMapping(value = "/AdminDodajHaslo.html", method= RequestMethod.GET)
	public String DodawanieEdycja(Model model, @RequestParam(value="id", defaultValue="-1") Long id)
	{
		if(id==-1)
				{
					pozycja p=new pozycja();				
					model.addAttribute("pozycja",p);
					return "AdminDodawanie";
				}
			else
			{			
				model.addAttribute("pozycja", dao.getPozycja(id));
				return "AdminDodawanie";
			}
		}
		
	@RequestMapping(value = "/AdminUsuwanie.html", method= RequestMethod.GET)
	public String usunPozycje(Model model, @RequestParam(value="did") int did)
	{			
				dao.deletePozycja(dao.getPozycja(did));
				model.addAttribute("listaPozycji",dao.getAllpozycja());				
				
				return "AdminPozycjeWszystkie";
	}
		
		
	@RequestMapping(value="/AdminDodajHaslo.html", method = RequestMethod.POST)
		public String DodawanieEdycjaPost(Model model,@ModelAttribute("pozycja") @Valid  pozycja pozycja,BindingResult result) throws Exception 
	{		
			if(result.hasErrors())
				return "AdminDodawanie";			
			else
			{					
					dao.saveOrUpdatePozycja(pozycja);
					model.addAttribute("listaPozycji",dao.getAllpozycja());	
					return "AdminPozycjeWszystkie";//"successView";
			}
	}
	
	//-****************************************************
	@RequestMapping(value="/AdminWyszukajPozycje.html", method= RequestMethod.GET)
	public String wyszukaj(Model model, @RequestParam(value="nazwa") String nazwa)
{		
		
		ArrayList<pozycja> Lista=(ArrayList<pozycja> )dao.getAllpozycja();
		ArrayList<pozycja> wyszukane=new ArrayList<pozycja>();
		for(int i=0;i<Lista.size();i++)
		{
			if(Lista.get(i).getNazwa().equals(nazwa))
			{
				wyszukane.add(Lista.get(i));
			}
		}
		model.addAttribute("listaPozycji", wyszukane);
				return "AdminPozycjeWszystkie";//"successView";
		}	
		
	
	//*******************************************************komentarze
	
	@RequestMapping(value="/AdminDodajKomentarz.html", method= RequestMethod.GET)
	public String dodajKomentarz(Model model, @RequestParam("login") String log, @RequestParam("tresc") String tr, @RequestParam("id") Integer id)
{		
		pozycja poz=dao.getPozycja(id);
		String komentarz=poz.getKomentarze();
		komentarz=komentarz+"<BR>"+System.getProperty("line.separator")+log+":<BR>"+System.getProperty("line.separator")+tr+"<BR>"+System.getProperty("line.separator");
		
		poz.setKomentarze(komentarz);
		dao.saveOrUpdatePozycja(poz);
		
		
		model.addAttribute("poz", dao.getPozycja(id));
		return "AdminPozycjaJedna";
		}	
		
		@ModelAttribute("listaKategorii")
		public ArrayList<Kategoria> loadTypes(){
			ArrayList<Kategoria> types =(ArrayList<Kategoria>) dao.getListaKategorii();			
			
			return types;
		}
		
		@RequestMapping(value = "/AdminEdycjaKom.html", method= RequestMethod.GET)
		public String EdytujKom(Model model, @RequestParam(value="did") int did)
		{			
					String komentarz=dao.getPozycja(did).getKomentarze();
					model.addAttribute("komentarze",komentarz);
					model.addAttribute("id",did);
					
					
					return "AdminEdycjaKomentarzy";
		}
		
		@RequestMapping(value = "/AdminEdycjaKom2.html", method= RequestMethod.GET)
		public String EdytujKom2(Model model, @RequestParam(value="kom") String komentarz,@RequestParam("id") Integer id)
		{			
					dao.getPozycja(id).setKomentarze(komentarz);
					
					model.addAttribute("poz", dao.getPozycja(id));
					return "AdminPozycjaJedna";
		}
	
	
}
