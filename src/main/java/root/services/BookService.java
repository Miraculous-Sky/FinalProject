package root.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import root.entity.Book;

@Service
public interface BookService {
	List<Book> findAll(String bookName);

	List<Book> getAllBook();

	void saveBook(Book book);

	void deleteBook(Book book);

	public Optional<Book> findUserById(int id);
}
