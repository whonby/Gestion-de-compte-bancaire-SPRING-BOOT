package com.whonby.banque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whonby.banque.entity.Compte;
import com.whonby.banque.metiere.BanqueMetieImpl;
import org.apache.commons.logging. Log;
import org.apache.commons.logging. LogFactory;
@Controller
public class BanqueController {
	  static Log log = LogFactory.getLog(BanqueController.class.getName());
    @Autowired
	private BanqueMetieImpl banqueMetieImpl;
	
	@GetMapping(value = "/operations")
	public String index(Model model) {
		return "comptes";
	}
	
	@GetMapping(value = "/consulterCompter")
	public String consuleter(Model model,String codeCpte) {
		try {
			Compte cp=banqueMetieImpl.consulterCompte(codeCpte);
			
			model.addAttribute("compte",cp);
		} catch (Exception e) {
			model.addAttribute("exception",e);
			
		}
		
		return "comptes";
	}
}
