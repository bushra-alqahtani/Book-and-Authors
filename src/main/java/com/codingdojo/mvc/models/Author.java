package com.codingdojo.mvc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	private String name;
	
	
	private String email;
	
	@OneToMany(mappedBy="author" , fetch=FetchType.LAZY)
	private List<Book> books;

	
	
	public Author() {
	
	}


	public Author(Long id, String name, String email, List<Book> books) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.books = books;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
