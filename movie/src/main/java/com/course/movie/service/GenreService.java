package com.course.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.GenreDto;
import com.course.movie.model.Genre;
import com.course.movie.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepository;

	
	public Genre save(GenreDto genreDto) {
		return genreRepository.save(createGenreFromDto(genreDto));
	}

	public Optional<Genre> findById(int id) throws NotFoundException {
		return genreRepository.findById(id);
		}

	public Genre update(Genre genre)  {
		if (genreRepository.existsById(genre.getGenreId())) {
			return genreRepository.save(genre);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return genre;	
		}
	}

	public void delete(int genreId) throws NotFoundException {
		if (genreRepository.existsById(genreId)) {
			genreRepository.deleteById(genreId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<Genre> getAll() {
		return genreRepository.findAll();
	}

	private Genre createGenreFromDto(GenreDto genreDto) {
		Genre genre = new Genre();
		genre.setName(genreDto.getName());
		return genre;
	}
}
