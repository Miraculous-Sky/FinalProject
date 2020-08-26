package root.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entity.Book;
import root.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAll(String bookName) {
		List<Book> result = new ArrayList<>();
		bookRepository.findAll().forEach(book -> {
			if (book.getTitle().contains(bookName))
				result.add(book);
		});
		return result;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> allBooks = (List<Book>) bookRepository.findAll();
		return allBooks;
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);

	}

}
