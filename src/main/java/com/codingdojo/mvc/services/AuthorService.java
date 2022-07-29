package com.codingdojo.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Author;
import com.codingdojo.mvc.repositories.AuthorRepository;

@Service
public class AuthorService {
  
	public final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
	this.authorRepository = authorRepository;
	}
	
	
	//create .save
	public Author createAuthor(Author author) {
		return authorRepository.save(author); 
	}
	
	
	//all authors
	public List<Author> getAllAuthors(){
		List<Author> authors=authorRepository.findAll();
		return authors;
		
	} 
	
	
	
	
}
