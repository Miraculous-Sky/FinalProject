package root.services;

import java.util.List;

import org.springframework.stereotype.Service;

import root.entity.Genre;

@Service
public interface GenreService {

	List<String> getNameAll();

	Genre findByID(long genreID);
}
