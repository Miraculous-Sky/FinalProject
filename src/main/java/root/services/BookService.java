package root.services;

import java.util.List;

import org.springframework.stereotype.Service;

import root.entity.Book;

@Service
public interface BookService {
	List<Book> findAll(String bookName);
}
