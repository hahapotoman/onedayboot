package com.hahapotoman.dev.book.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hahapotoman.dev.book.dto.BookCreateDTO;
import com.hahapotoman.dev.book.dto.BookEditResponseDTO;
import com.hahapotoman.dev.book.dto.BookReadResponseDTO;
import com.hahapotoman.dev.book.entity.Book;
import com.hahapotoman.dev.book.entity.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public Integer insert(BookCreateDTO bookCreateDTO) {
		Book book = Book.builder()
				.title(bookCreateDTO.getTitle())
				.price(bookCreateDTO.getPrice())
				.build();
		this.bookRepository.save(book);
		return book.getBookId();
	}
	public BookReadResponseDTO read(Integer bookId) throws NoSuchElementException {
		Book book = this.bookRepository.findById(bookId).orElseThrow();
		BookReadResponseDTO bookReadResponseDTO = new BookReadResponseDTO();
		bookReadResponseDTO.fromBook(book);
		return bookReadResponseDTO;		
	}
	public BookEditResponseDTO edit(Integer bookId) throws NoSuchElementException {
		Book book = this.bookRepository.findById(bookId).orElseThrow();		
		return BookEditResponseDTO.BookFactory(book);		
	}
	
}
