package com.example.universityexample.universityexample.university;

import com.example.universityexample.universityexample.address.Address;
import com.example.universityexample.universityexample.address.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {

    UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);

    University universityDtoToUniversity(UniversityDto universityDto);
    UniversityDto universityToUniversityDto(University university);

    // This prevents a recursive StackOverflowError
    @Mapping(target = "owner", ignore = true)
    Address addressDtoToAddress(AddressDto addressDto);
    @Mapping(target = "owner", ignore = true)
    AddressDto addressToAddressDto(Address address);
}
