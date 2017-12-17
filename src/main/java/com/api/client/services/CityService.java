package com.api.client.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.api.client.model.City;
import com.api.client.repository.CityRepository;
import com.api.client.service.exceptions.CityExistingException;
import com.api.client.service.exceptions.CityNotFoundException;

@Service
public class CityService{

	@Autowired
	private CityRepository cityRepository;

	public List<City>list(){
		return cityRepository.findAll();
	}

	public City searchForCode(Long id){
		City city = cityRepository.findOne(id);
		if (city == null){
			throw new CityNotFoundException("City not found.");
		}
		return city;
	}
	public City save(City city){
		if(city.getId() != null){
			
			City cityExisting = searchForCode(city.getId());
			
			if(cityExisting != null){
				throw new CityExistingException("city already existing.");
			}
		}
		return cityRepository.save(city);
	}

	public void update(City city){
		checkExisting(city);
		cityRepository.save(city);
	}

	public void delete(Long id){
		try{
			cityRepository.delete(id);
		}catch (EmptyResultDataAccessException e){
			throw new CityNotFoundException("City not found.");
		}
	}

	private void checkExisting(City city){
		searchForCode(city.getId());
	}
}
