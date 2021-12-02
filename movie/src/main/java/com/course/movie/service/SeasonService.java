package com.course.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.SeasonDto;
import com.course.movie.model.Content;
import com.course.movie.model.Season;
import com.course.movie.repository.ContentRepository;
import com.course.movie.repository.SeasonRepository;

@Service
public class SeasonService {
	@Autowired
	SeasonRepository seasonRepository;
	@Autowired
	ContentRepository contentRepository;
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
		//season.setContentID(seasonDto.getContentID());
		List<Content> list= new ArrayList<Content>(); 
		list=this.contentRepository.findAll();
		//Boolean jePronadjen=false;
	    for(int i=0; i<list.size();i++) {
		Content trazeni = list.get(i);
	    if(trazeni.getContentID()==seasonDto.getContentID()) {
	    	 season.setContent(trazeni);
		}
	    
	    }
	   
			
		return season;
	}
}
