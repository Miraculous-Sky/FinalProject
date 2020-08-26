package root.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import root.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
