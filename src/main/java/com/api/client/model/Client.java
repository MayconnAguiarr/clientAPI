package com.api.client.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "client")
public class Client{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "The field can't be empty.")
	private String name;

	@JsonInclude(Include.NON_NULL)
	private String cpf;

	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "The field address is required.")
	private String address;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	
	@JsonInclude(Include.NON_NULL)
	@Size(max = 1500,message = "The field obs can't contein more  that 1500 characters.")
	private String obs;
		
	@ManyToOne 
	@JoinColumn(name = "CITY_ID")
	@JsonInclude(Include.NON_NULL)
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getCpf(){
		return cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public Date getBirthDate(){
		return birthDate;
	}

	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}

	public String getObs(){
		return obs;
	}

	public void setObs(String obs){
		this.obs = obs;
	}

	public City getCity(){
		return city;
	}

	public void setCity(City city){
		this.city = city;
	}		
}
