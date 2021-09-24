package com.bookStore.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository <Book, Long> {
	
	@Query("SELECT u FROM Book u WHERE u.id = ?1")
	Book findById(long id);
}
