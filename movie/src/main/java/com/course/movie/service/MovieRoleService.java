package com.course.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.MovieRoleDto;
import com.course.movie.model.MovieRole;
import com.course.movie.repository.MovieRoleRepository;
@Service
public class MovieRoleService {
	@Autowired
	MovieRoleRepository movieRoleRepository;
	
	public MovieRole insert(MovieRoleDto movieRoleDto) {
		return movieRoleRepository.save(createMovieRoleFromDto(movieRoleDto));
	}

	public Optional<MovieRole> findById(int id) throws NotFoundException {
		return movieRoleRepository.findById(id);
		}

	public MovieRole update(MovieRole movieRole)  {
		if (movieRoleRepository.existsById(movieRole.getMovieRoleID())) {
			return movieRoleRepository.save(movieRole);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return movieRole;	
		}
	}
   
	public void delete(int mrID) throws NotFoundException {
		if (movieRoleRepository.existsById(mrID)) {
			movieRoleRepository.deleteById(mrID);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
			
		}
	}

	public List<MovieRole> getAll() {
		return movieRoleRepository.findAll();
	}

	private MovieRole createMovieRoleFromDto(MovieRoleDto movieRoleDto) {
		MovieRole mr = new MovieRole();
		mr.setName(movieRoleDto.getName());
	
		

		return mr;
	}
}
