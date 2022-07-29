package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

	
	List<Author> findAll();
}
