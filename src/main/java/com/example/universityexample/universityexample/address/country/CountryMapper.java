package com.example.universityexample.universityexample.address.country;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country cityToCityDto(CountryDto cityDto);
    CountryDto cityDtoToCity(Country city);
}
