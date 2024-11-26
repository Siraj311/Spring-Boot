package com.learnwithiftikar.native_query;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NativeQueryApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public NativeQueryApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NativeQueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		bookRepository.findBooksByTitleThatContainsWord("Men").forEach(book -> {
//			System.out.println(book.toString());
//		});

		bookRepository.updateBookPrice(50.00, 1L);
		bookRepository.findById(1L).ifPresent(book -> {
			System.out.println(book.toString());
		});
	}
}
