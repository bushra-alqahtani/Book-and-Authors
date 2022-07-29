package com.codingdojo.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.mvc.models.Author;
import com.codingdojo.mvc.services.AuthorService;

@Controller
public class AuthorController {

	
	
	public final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value="/authors/create" ,method=RequestMethod.GET)
	public String createAuthor(@ModelAttribute("Author") Author author) {
		return "authors/create.jsp";
	}
	
	@RequestMapping(value="/authors/create" ,method=RequestMethod.POST)
	public String storeAuthor(@Valid @ModelAttribute("Author") Author author,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("we have an Error/s");
			return "authors/create.jsp";
		}else {
			authorService.createAuthor(author);
			redirectAttributes.addFlashAttribute("success","the auther has been created successfully.");
			return "redirect:/authors/create";
		}	
	}
	
	
}
