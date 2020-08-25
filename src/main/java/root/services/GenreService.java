package root.services;

import java.util.List;

import root.entity.Genre;

public interface GenreService {

	List<String> findAll();

	Genre findByID(long genreID);
}
