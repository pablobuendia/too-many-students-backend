package com.pablobuendia.universitymanager.entities.address.city;

import com.pablobuendia.universitymanager.entities.address.country.Country;
import com.pablobuendia.universitymanager.entities.address.country.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {

  CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

  City cityToCityDto(CityDto cityDto);

  CityDto cityDtoToCity(City city);

  Country cityToCityDto(CountryDto cityDto);

  CountryDto cityDtoToCity(Country city);
}
