package root.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import root.entity.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

}
