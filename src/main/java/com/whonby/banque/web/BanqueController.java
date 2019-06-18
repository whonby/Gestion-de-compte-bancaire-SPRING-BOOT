package com.whonby.banque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whonby.banque.entity.Compte;
import com.whonby.banque.entity.Operation;
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
	public String consuleter(Model model,String codeCpte,@RequestParam(name="page",defaultValue ="0")int p,@RequestParam(name="size",defaultValue ="6")int s) {
		 model.addAttribute("codeCompte",codeCpte);
		
		try {
			Compte cp=banqueMetieImpl.consulterCompte(codeCpte);
			Page<Operation> pageOperation=banqueMetieImpl.listOperation(codeCpte, p, s);
			model.addAttribute("compte",cp);
			model.addAttribute("listeOperation",pageOperation.getContent());
			
			int[] pages=new int[pageOperation.getTotalPages()];
			model.addAttribute("page", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			
		} catch (Exception e) {
			String message=e.getMessage();
			if (message.equals("No value present")) {
				message="Compte introuvable";
			}
			model.addAttribute("exception",message);
			
		}
		
		return "comptes";
	}
	
	@PostMapping(value = "/saveOperation")
	public String saveOperation(Model model,String typeOperation,String codeCpte2,double montant,String codeCpte) {
		
		
		try {
			if (typeOperation.equals("VERS")) {
				banqueMetieImpl.verser(codeCpte, montant);
			}
			if (typeOperation.equals("RETR")) {
				banqueMetieImpl.retirer(codeCpte, montant);
			}
			
			if (typeOperation.equals("VIR")) {
				banqueMetieImpl.virement(codeCpte, codeCpte2, montant);
			}
		} catch (Exception e) {
			String message=e.getMessage();
			if (message.equals("No value present")) {
				message="imposible de faire le virement car, le compte "+codeCpte2+" n'existe pas dans notre basse de donne ";
			}
			model.addAttribute("error",message);
			return "redirect:/consulterCompter?codeCpte="+codeCpte+"&error="+message;
		}
		
		return "redirect:/consulterCompter?codeCpte="+codeCpte;
		
	}
}
