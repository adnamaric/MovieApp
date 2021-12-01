package com.course.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.course.movie.dto.EpisodeDto;
import com.course.movie.model.Episode;
import com.course.movie.repository.EpisodeRepository;

@Service
public class EpisodeService {

	@Autowired
	EpisodeRepository episodeRepository;

	public Episode save(EpisodeDto episodeDto) {
		return episodeRepository.save(createEpisodeFromDto(episodeDto));
	}

	public Optional<Episode> findById(int id) throws NotFoundException {
		return episodeRepository.findById(id);
		}

	public Episode update(Episode episode)  {
		if (episodeRepository.existsById(episode.getEpisodeID())) {
			return episodeRepository.save(episode);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return episode;	
		}
	}

	public void delete(int episodeId) throws NotFoundException {
		if (episodeRepository.existsById(episodeId)) {
			episodeRepository.deleteById(episodeId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<Episode> getAll() {
		return episodeRepository.findAll();
	}

	private Episode createEpisodeFromDto(EpisodeDto episodeDto) {
		Episode episode = new Episode();
		episode.setEpisodeName(episodeDto.getName());
		episode.setDuration(episodeDto.getDuration());
		episode.setEpisodeNumber(episode.getEpisodeNumber());
		return episode;
	}
}
