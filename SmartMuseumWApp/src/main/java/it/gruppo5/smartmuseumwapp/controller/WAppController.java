package it.gruppo5.smartmuseumwapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import it.gruppo5.smartmuseumwapp.database.Opera;
import it.gruppo5.smartmuseumwapp.service.Manager;


@Controller
public class WAppController {
	
	@Autowired
	Manager manager;
		
	@RequestMapping("/home")
	public String getHomePage(Model model) {
		//View visitors value in home page
		String permission = "Ingresso Consentito";
		Integer visitors = manager.getNumOfVisitors();
		if(visitors > 100)
			permission = "Ingresso NON Consentito";
		model.addAttribute("permission", permission);
		model.addAttribute("visitors", visitors.toString());
		
		List<Opera> incomingArtworks = manager.getIncomingOpera();
		model.addAttribute("artworks", incomingArtworks);
		
		return "homePage";
	}
	
	@RequestMapping("/artworks")
	//@ResponseBody                    // add @ResponseBody if no template is used
	public String getArtworksPage (@RequestParam(name = "name", required = false,
								defaultValue = "World") String n, Model model) {
		
		//model.addAttribute("personName", n);
		
		
		//String[] str = {"stringa 1", "stringa 2", "stringa 3"};
		//model.addAttribute("str", str);
		
		List<Opera> artworks = manager.getSortedArtList(0);
		model.addAttribute("artworks", artworks);
		
		
		
		//List<Opera> incomingArtworks = Manager.getIncomingOpera();
		//model.addAttribute("incomingArtworks", incomingArtworks);
		
		return "artworksPage";
	}
	
	
	
	@RequestMapping("/artwork")
	public String getArtworkPage (@RequestParam(name = "ID", 
								required = true) String artworkID, Model model) {
		
		model.addAttribute("artwork", manager.getOperaByID(Integer.parseInt(artworkID)));
		
		
		return "artworkPage";
	}
	
	@RequestMapping("/gallery")
	public String getGalleryPage () {
		
		return "galleryPage";
	}
		

}