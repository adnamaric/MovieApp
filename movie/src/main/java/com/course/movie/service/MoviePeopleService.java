package com.course.movie.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.MoviePeopleDto;
import com.course.movie.dto.MoviePeopleRoleDto;
import com.course.movie.model.Content;
import com.course.movie.model.MoviePeople;
import com.course.movie.model.MoviePeopleRole;
import com.course.movie.model.MoviePeopleRoleKey;
import com.course.movie.model.MovieRole;
import com.course.movie.model.Review;
import com.course.movie.model.ReviewKey;
import com.course.movie.model.User;
import com.course.movie.repository.MoviePeopleRepository;
import com.course.movie.repository.MoviePeopleRoleRepository;
import com.course.movie.repository.MovieRoleRepository;

@Service
public class MoviePeopleService {
	@Autowired
	MoviePeopleRepository moviePeopleRepository;
	@Autowired
	MoviePeopleRoleRepository moviePeopleRoleRepository;
	@Autowired
	MovieRoleRepository movieRoleRepository;
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
	private MoviePeopleRole addRoleToPeople(MoviePeopleRoleDto moviePeopleRoleDto) {
	
//		 User user=new User();
//		  Content content=new Content();
//		  content=this.contentRepository.getById(reviewDto.getContentID());
//		  user=this.userRepository.getById(reviewDto.getUserID());
//		  ReviewKey noviKey=new ReviewKey();
//		  noviKey.setContentID(content.getContentID());
//		  noviKey.setUserID(user.getUserID());
//		  this.reviewRepository.save(new Review(noviKey,user,content,reviewDto.getRating(),reviewDto.getFavourite()));
//		  return new Review(noviKey,user,content,reviewDto.getRating(),reviewDto.getFavourite());
		MovieRole movieRole = new MovieRole();
		MoviePeople moviePeople= new MoviePeople();
		movieRole=this.movieRoleRepository.getById(moviePeopleRoleDto.getMovieRoleID());
		moviePeople=this.moviePeopleRepository.getById(moviePeopleRoleDto.getMoviePeopleID());
		MoviePeopleRoleKey novi=new MoviePeopleRoleKey();
		novi.setMoviePeopleID(moviePeopleRoleDto.getMoviePeopleID());
		novi.setMovieRoleID(moviePeopleRoleDto.getMovieRoleID());
		this.moviePeopleRoleRepository.save(new MoviePeopleRole(novi,movieRole,moviePeople));
	
		return new MoviePeopleRole(novi,movieRole,moviePeople);
		
		
	}
	public MoviePeopleRole addRole(MoviePeopleRoleDto moviePeopleRoleDto) {
		return moviePeopleRoleRepository.save(addRoleToPeople(moviePeopleRoleDto));
	}
}


