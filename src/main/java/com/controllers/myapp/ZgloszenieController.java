package com.controllers.myapp;

import javax.validation.Valid;

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

import dao.kategoriaDao;
import dao.pozycjaDao;
import dao.zgloszenieDao;
import domain.Kategoria;
import domain.Zgloszenie;
import domain.pozycja;

@Controller
@SessionAttributes(value={"listaZgloszen"})
public class ZgloszenieController {
	@Autowired
	zgloszenieDao dao;
	
	@Autowired
	pozycjaDao dao2;
	
	@RequestMapping(value = "/zgloszeniaWszystkie.html", method= RequestMethod.GET)
	public String wszystkiePozycje(ModelMap model) throws Exception
	{		
		model.addAttribute("listaZgloszen", dao.getAllZgloszenie());		
		return "zgloszeniaWszystkie";		
	}
	
	@RequestMapping(value = "/usuwanieZgloszenia.html", method= RequestMethod.GET)
	public String usunKategorie(Model model, @RequestParam(value="did") long did)
	{			
				dao.deleteZgloszenie(dao.getZgloszenie(did));
				model.addAttribute("listaZgloszen",dao.getAllZgloszenie());				
				
				return "zgloszeniaWszystkie";
	}
	
	
	@RequestMapping(value = "/dodajZgloszenie.html", method= RequestMethod.GET)
	public String DodawanieEdycja(Model model, @RequestParam(value="idd") Long idd,@RequestParam(value="tresc") String tresc)
	{
		
					Zgloszenie z=new Zgloszenie();	
					z.setIdZglaszanegoHasla(idd);
					z.setNazwaHasla(dao2.getPozycja(idd).getNazwa());					
					z.setTrescZgloszenia(tresc);				
					
					dao.saveOrUpdateZgloszenie(z);
					model.addAttribute("poz",dao2.getPozycja(idd));				
					
					return "pozycjaJedna";		
			
	}
	
}
