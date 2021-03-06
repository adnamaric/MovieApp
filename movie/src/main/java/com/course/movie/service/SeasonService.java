package com.course.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.SeasonDto;
import com.course.movie.dto.SerieCastDto;
import com.course.movie.model.Content;
import com.course.movie.model.MoviePeople;
import com.course.movie.model.MovieRole;
import com.course.movie.model.Season;
import com.course.movie.model.SerieCast;
import com.course.movie.model.SerieCastKey;
import com.course.movie.repository.ContentRepository;
import com.course.movie.repository.MoviePeopleRepository;
import com.course.movie.repository.MovieRoleRepository;
import com.course.movie.repository.SeasonRepository;
import com.course.movie.repository.SerieCastRepository;

@Service
public class SeasonService {
	@Autowired
	SeasonRepository seasonRepository;
	@Autowired
	ContentRepository contentRepository;
	@Autowired
	SerieCastRepository serieCastRepository;
	@Autowired
	MovieRoleRepository movieRoleRepository;
	@Autowired
	MoviePeopleRepository moviePeopleRepository;
	
	public Season save(SeasonDto seasonDto) {
		return seasonRepository.save(createSeasonFromDto(seasonDto));
	}

	public Optional<Season> findById(int id) throws NotFoundException {
		return seasonRepository.findById(id);
		}

	public Season update(Season season)  {
		if (seasonRepository.existsById(season.getSeasonID())) {
			return seasonRepository.save(season);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return season;	
		}
	}

	public void delete(int episodeId) throws NotFoundException {
		if (seasonRepository.existsById(episodeId)) {
			seasonRepository.deleteById(episodeId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<Season> getAll() {
		return seasonRepository.findAll();
	}

	private Season createSeasonFromDto(SeasonDto seasonDto) {
		Season season = new Season();
		season.setSeasonName(seasonDto.getSeasonName());
		season.setSeasonNumber(seasonDto.getSeasonNumber());
		List<Content> list= new ArrayList<Content>(); 
		list=this.contentRepository.findAll();
	    for(int i=0; i<list.size();i++) {
		Content trazeni = list.get(i);
	    if(trazeni.getContentID()==seasonDto.getContentID()) {
	    	 season.setContent(trazeni);
		 }
	    
	    }
	   
			
		return season;
	}
	public SerieCast addSerieCast (SerieCastDto serieCastDto) {
		return serieCastRepository.save(addCast(serieCastDto));
	}
	private SerieCast addCast(SerieCastDto serieCastDto) {
 		Season season = new Season();
 		season=this.seasonRepository.getById(serieCastDto.getSeasonId());
 		MovieRole movieRole=new MovieRole();
 		movieRole=this.movieRoleRepository.getById(serieCastDto.getMovieRoleID());
 		MoviePeople moviePeople=new MoviePeople();
 		moviePeople=this.moviePeopleRepository.getById(serieCastDto.getMoviePeopleID());
 		SerieCastKey n=new SerieCastKey();
 		n.setMoviePeopleID(serieCastDto.getMoviePeopleID());
 		n.setMovieRoleID(serieCastDto.getMovieRoleID());
 		n.setSeasonId(serieCastDto.getSeasonId());
 		this.serieCastRepository.save(new SerieCast(n,season,movieRole,moviePeople));
		return new SerieCast(n,season,movieRole,moviePeople);
	}
}
