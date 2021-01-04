package com.example.demo;

import database.Opera;
import database.Manager;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/page2")
	//@ResponseBody                    // add @ResponseBody if no template is used
	public String secondPage (@RequestParam(name = "name", required = false,
								defaultValue = "World") String n, Model model) {
		
		model.addAttribute("personName", n);
		
		//String[] str = {"stringa 1", "stringa 2", "stringa 3"};
		//model.addAttribute("str", str);
		
		//List<Opera> artworks = Manager.getArtList();
		//model.addAttribute("artworks", artworks);
		
		//List<Opera> soldArtworks = Manager.getSoldOpera();
		//model.addAttribute("soldArtworks", soldArtworks);
		return "page2";
	}

}