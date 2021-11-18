package io.javabrains.musicapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.javabrains.musicapi.models.UserEmailModel;

@SpringBootTest
class MusicApiApplicationTests {

	@Test
	void contextLoads() {
		UserEmailModel user = new UserEmailModel();
		assertNotNull(user);
	}

}
