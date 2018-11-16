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
import domain.Kategoria;
import domain.pozycja;

@Controller
@SessionAttributes(value={"listaKategorii"})
public class KategoriaController {
	@Autowired
	kategoriaDao dao;
	
	@RequestMapping(value = "/kategorieWszystkie.html", method= RequestMethod.GET)
	public String wszystkiePozycje(ModelMap model) throws Exception
	{		
		model.addAttribute("listaKategorii", dao.getAllKategorie());		
		return "kategorieWszystkie";		
	}
	
	@RequestMapping(value = "/kategoriaDodawanieEdycja.html", method= RequestMethod.GET)
	public String DodawanieEdycja(Model model, @RequestParam(value="id", defaultValue="-1") Long id)
	{
		if(id==-1)
				{
					Kategoria k=new Kategoria();				
					model.addAttribute("kategoria",k);
					return "dodawanieKategorii";
				}
			else
			{			
				model.addAttribute("kategoria", dao.getKategoria(id));
				return "dodawanieKategorii";
			}
	}
	
	@RequestMapping(value="/kategoriaDodawanieEdycja.html", method = RequestMethod.POST)
	public String DodawanieEdycjaPost(Model model,@ModelAttribute("kategoria") @Valid  Kategoria kategoria,BindingResult result) throws Exception 
{		
		if(result.hasErrors())
			return "dodawanieKategorii";			
		else
		{					
				dao.saveOrUpdateKategoria(kategoria);
				model.addAttribute("listaKategorii",dao.getAllKategorie());	
				return "kategorieWszystkie";//"successView";
		}
}
	
	@RequestMapping(value = "/usuwanieKategorii.html", method= RequestMethod.GET)
	public String usunKategorie(Model model, @RequestParam(value="did") int did)
	{			
				dao.deleteKategoria(dao.getKategoria(did));
				model.addAttribute("listaKategorii",dao.getAllKategorie());				
				
				return "kategorieWszystkie";
	}
	
	
}
