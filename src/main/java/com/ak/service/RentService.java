package main.java.com.ak.service;

import java.util.List;

import main.java.com.ak.model.Book;
import main.java.com.ak.model.Rent;
import main.java.com.ak.model.User;

public interface RentService {
	void createRent(User user, Book book);
	List<Rent> findByUserOrderByCreateDateDesc(User user);
	List<Rent> findAll();
}
