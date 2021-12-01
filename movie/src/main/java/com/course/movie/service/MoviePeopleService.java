package com.course.movie.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.MoviePeopleDto;
import com.course.movie.model.MoviePeople;
import com.course.movie.repository.MoviePeopleRepository;

@Service
public class MoviePeopleService {
	@Autowired
	MoviePeopleRepository moviePeopleRepository;
	
	public MoviePeople insert(MoviePeopleDto moviePeopleDto) {
		return moviePeopleRepository.save(createMoviePeopleFromDto(moviePeopleDto));
	}

	public Optional<MoviePeople> findById(int id) throws NotFoundException {
		return moviePeopleRepository.findById(id);
		}

	public MoviePeople update(MoviePeople moviePeople)  {
		if (moviePeopleRepository.existsById(moviePeople.getMoviePeopleID())) {
			return moviePeopleRepository.save(moviePeople);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return moviePeople;	
		}
	}
   
	public void delete(int mrID) throws NotFoundException {
		if (moviePeopleRepository.existsById(mrID)) {
			moviePeopleRepository.deleteById(mrID);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
			
		}
	}

	public List<MoviePeople> getAll() {
		return moviePeopleRepository.findAll();
	}

	private MoviePeople createMoviePeopleFromDto(MoviePeopleDto moviePeopleDto) {
		MoviePeople mp = new MoviePeople();
		mp.setFirstName(moviePeopleDto.getFirstName());
		mp.setLastName(moviePeopleDto.getLastName());
		mp.setGender(moviePeopleDto.getGender());
      //  mp.setBirthDate(new Date(1,1,1997));
		return mp;
	}
}


