package main.java.com.ak.service;

import java.util.List;

import main.java.com.ak.model.Book;

public interface BookService {
	List<Book> findAll();
	Book findOne(Long id);
	void save(Book book);
	void delete(Long id);
}
