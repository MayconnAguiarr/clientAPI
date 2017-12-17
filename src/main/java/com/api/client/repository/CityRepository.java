package com.api.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.client.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
