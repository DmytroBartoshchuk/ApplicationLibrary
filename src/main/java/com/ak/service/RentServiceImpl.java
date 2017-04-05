package main.java.com.ak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.ak.dao.RentDao;
import main.java.com.ak.model.Book;
import main.java.com.ak.model.Rent;
import main.java.com.ak.model.User;

public class RentServiceImpl implements RentService {
	
	@Autowired
	RentDao rentDao;
	
	@Override
	public void createRent(User user, Book book) {
		////////////////////
		
	}

	@Override
	public List<Rent> findByUserOrderByCreateDateDesc(User user) {
		
		return rentDao.findByUserOrderByCreateDateDesc(user);
	}

	@Override
	public List<Rent> findAll() {
		return rentDao.findAll();
	}

}
