package main.java.com.ak.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.ak.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

}
