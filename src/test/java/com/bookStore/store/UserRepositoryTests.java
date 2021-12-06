package com.bookStore.store;

import static org.assertj.core.api.Assertions.assertThat; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstName("testUser");
		user.setLastName("userTest");
		user.setMail("test.test@test.com");
		user.setPassword("Test2021_2020");
		
		User savedUser = repo.save(user);
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getMail()).isEqualTo(user.getMail());
		
	}
	@Test
	public void testFindUserByEmail() {
		String email = "test.test@test.com";
		
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
