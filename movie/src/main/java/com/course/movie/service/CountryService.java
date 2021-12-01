package com.course.movie.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.course.movie.dto.CountryDto;
import com.course.movie.model.Country;
import com.course.movie.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	
	public Country save(CountryDto countryDto) {
		return countryRepository.save(createCountryFromDto(countryDto));
	}

	public Optional<Country> findById(int id) throws NotFoundException {
		return countryRepository.findById(id);
		}

	public Country update(Country country)  {
		if (countryRepository.existsById(country.getCountryID())) {
			return countryRepository.save(country);
		}
//		throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genre.getGenreId());
		else {
			return country;	
		}
	}
   
	public void delete(int countryId) throws NotFoundException {
		if (countryRepository.existsById(countryId)) {
			countryRepository.deleteById(countryId);
		} else {
//			throw new NotFoundException("Nije pronaÄ‘en Å¾anr sa id-em:" + genreId);
		}
	}

	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	private Country createCountryFromDto(CountryDto countryDto) {
		Country country= new Country();
		country.setCountryName(countryDto.getCountryName());
		country.setCode(countryDto.getCode());
		

		return country;
	}
}
