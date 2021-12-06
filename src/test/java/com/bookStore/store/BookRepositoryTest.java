package com.bookStore.store;


import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(true)
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateBook() {
		Book book = new Book();
		book.setAuthor("Mr Test");
		book.setTitle("test o test");
		book.setPublishDate(Date.valueOf("2021-09-23"));
		book.setDownloadLink("https://www.googl.co.in/");
		
		Book savedBook = bookRepo.save(book);
		Book availableBook = entityManager.find(Book.class, savedBook.getId());
		assertThat(savedBook.getAuthor()).isEqualTo(availableBook.getAuthor());
		assertThat(savedBook.getTitle()).isEqualTo(availableBook.getTitle());
	}
	
}
