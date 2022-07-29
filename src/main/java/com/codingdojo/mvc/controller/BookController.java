package com.codingdojo.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Author;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.AuthorService;
import com.codingdojo.mvc.services.BookService;

@Controller

public class BookController {
	//dependency injection 
	
	private final BookService bookService;
	private final AuthorService authorService;
	
	
	public BookController(BookService bookService, AuthorService authorService) {
		super();
		this.bookService = bookService;
		this.authorService = authorService;
	}
	//create the book
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book ,Model model) {
		List<Author> authors=authorService.getAllAuthors();
		model.addAttribute("authors",authors);
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {  // for Error checking i use @valid 
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
	
	//rendering information of the book in separate page 
	@RequestMapping("/{bookId}")
	public String index(Model model,@PathVariable("bookId") Long bookId) {
		Book book=bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "/books/index.jsp";
	}
    
		    
	

}
