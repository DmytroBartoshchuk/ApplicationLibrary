package main.java.com.ak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.ak.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
		User findByEmail(String email);
}
