package root.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entity.Genre;
import root.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<String> findAll() {
		List<String> result = new ArrayList<>();
		genreRepository.findAll().forEach(genre -> result.add(genre.getName()));
		return result;
	}

	@Override
	public Genre findByID(long genreID) {
		return null;
	}
}
