package com.api.client.rest;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.api.client.model.City;
import com.api.client.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<City>> list(){
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(cityService.list());				
	}
		
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> SearchForCode(@PathVariable("id") Long id){
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(cityService.searchForCode(id));				
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody City city){
		
		city = cityService.save(city);
		
		// create a URI to access
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(city.getId())
				.toUri();

		return ResponseEntity.created(uri).build();	
	}										

	@RequestMapping(value = "/update/{id}")
	public ResponseEntity<Void> update(@RequestBody City city, @PathVariable("id")Long id){
		
		city.setId(id);
		
		cityService.update(city);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		cityService.delete(id);
		return ResponseEntity.noContent().build();
	}				
}
