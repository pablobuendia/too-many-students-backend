package com.example.universityexample.universityexample.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    // This prevents a recursive StackOverflowError
    @Mapping(target = "student.addressList", ignore = true)
    Address addressDtoToAddress(AddressDto addressDto);
    @Mapping(target = "student.addressList", ignore = true)
    AddressDto addressToAddressDto(Address address);
}
