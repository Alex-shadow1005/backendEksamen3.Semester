package com.example.backendeksamen3semester;

import com.example.backendeksamen3semester.model.Newsletter;
import com.example.backendeksamen3semester.repository.NewsletterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private NewsletterRepository newsletterRepository;

	@Test
	void sendnewslettertest() {
		int numbers = newsletterRepository.findAll().size();
		int expected = 1;
		assertEquals(expected, numbers);
	}

	@Test
	void createanddeleteemailtest() {
		Newsletter newsletter = new Newsletter();
		newsletter.setEmail("unittest@gmail.com");
		newsletterRepository.save(newsletter);
		assertEquals("unittest@gmail.com", newsletter.getEmail());

		int count = newsletterRepository.findAll().size();

		newsletterRepository.delete(newsletter);

		int count2 = newsletterRepository.findAll().size();
		assertEquals(count-1, count2);
	}

	@Test
	void updateemailtest(){
		Newsletter newsletter = new Newsletter();

		if(newsletterRepository.existsById(1)){
			newsletter.setNewsletterid(1);
			newsletter.setEmail("changedmail@gmail.com");
			newsletterRepository.save(newsletter);

			assertEquals("changedmail@gmail.com", newsletter.getEmail());
			System.out.println(newsletter.getEmail());
		}
	}
}
