package main.java.com.ak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.ak.model.Rent;
import main.java.com.ak.model.User;

@Repository
public interface RentDao extends JpaRepository<Rent, Long> {
	List<Rent> findByUserOrderByCreateDateDesc(User user);
}
