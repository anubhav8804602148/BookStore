package com.bookStore.store;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.SpringApplication; 
import org.springframework.context.ConfigurableApplicationContext;
import org.junit.jupiter.api.Test;

public class UITesting {
	@Test
	public void checkIfAppLaunching() {
		try {
			ConfigurableApplicationContext app = SpringApplication.run(BookStoreApplication.class);
			app.close();
		} catch (Exception e) {
			e.printStackTrace();
			assertThat(1).isEqualTo(2);
		}
	}
}
