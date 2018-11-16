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
import dao.pozycjaDao;
import domain.Kategoria;
import domain.pozycja;



/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value={"listaPozycji"})
public class PozycjiController {
	
	
	@Autowired
	pozycjaDao dao;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/pozycjeWszystkie.html", method= RequestMethod.GET)
	public String wszystkiePozycje(ModelMap model) throws Exception
	{		
		model.addAttribute("listaPozycji", dao.getAllpozycja());		
		return "pozycjeWszystkie";		
	}
	
	@RequestMapping(value = "/pozycjeWszystkie.html", method= RequestMethod.GET ,params={"id"})
	public String wyswietlPozycjeOID(Model model, @RequestParam("id") long id) 
	{	
				model.addAttribute("poz", dao.getPozycja(id));	
		return "pozycjaJedna";
	}
	
	@RequestMapping(value = "/pozycjaForm.html", method= RequestMethod.GET)
	public String DodawanieEdycja(Model model, @RequestParam(value="id", defaultValue="-1") Long id)
	{
		if(id==-1)
				{
					pozycja p=new pozycja();				
					model.addAttribute("pozycja",p);
					return "dodawanie";
				}
			else
			{			
				model.addAttribute("pozycja", dao.getPozycja(id));
				return "dodawanie";
			}
		}
		
	@RequestMapping(value = "/usuwanie.html", method= RequestMethod.GET)
	public String usunPozycje(Model model, @RequestParam(value="did") int did)
	{			
				dao.deletePozycja(dao.getPozycja(did));
				model.addAttribute("listaPozycji",dao.getAllpozycja());				
				
				return "pozycjeWszystkie";
	}
		
		
	@RequestMapping(value="/pozycjaForm.html", method = RequestMethod.POST)
		public String DodawanieEdycjaPost(Model model,@ModelAttribute("pozycja") @Valid  pozycja pozycja,BindingResult result) throws Exception 
	{		
			if(result.hasErrors())
				return "dodawanie";			
			else
			{					
					dao.saveOrUpdatePozycja(pozycja);
					model.addAttribute("listaPozycji",dao.getAllpozycja());	
					return "pozycjeWszystkie";//"successView";
			}
	}
	
	//-****************************************************
	@RequestMapping(value="/wyszukajPozycje.html", method= RequestMethod.GET)
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
				return "pozycjeWszystkie";//"successView";
		}

	
	
	//****************************************************************
	
	@RequestMapping(value="/dodajKomentarz.html", method= RequestMethod.GET)
	public String dodawanieKomentarza(Model model, @RequestParam(value="nazwa") String nazwa)
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
				return "pozycjeWszystkie";//"successView";
		}

	
	//****************************************************************
	@RequestMapping(value="/DodajKomentarz.html", method= RequestMethod.GET)
	public String dodajKomentarz(Model model, @RequestParam("login") String log, @RequestParam("tresc") String tr, @RequestParam("id") Integer id)
{		
		pozycja poz=dao.getPozycja(id);
		String komentarz=poz.getKomentarze();
		komentarz=komentarz+"<BR>"+System.getProperty("line.separator")+log+":<BR>"+System.getProperty("line.separator")+tr+"<BR>"+System.getProperty("line.separator");
		
		poz.setKomentarze(komentarz);
		dao.saveOrUpdatePozycja(poz);
		
		
		model.addAttribute("poz", dao.getPozycja(id));
		return "pozycjaJedna";
		}	
	
	
	//******************************************************************
		@ModelAttribute("listaKategorii")
		public ArrayList<Kategoria> loadTypes(){
			ArrayList<Kategoria> types =(ArrayList<Kategoria>) dao.getListaKategorii();			
			
			return types;
		}
		
	
	
	
	
}
