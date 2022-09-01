package com.pablobuendia.universitymanager.university;

import com.pablobuendia.universitymanager.commons.BaseEntity;
import com.pablobuendia.universitymanager.commons.BaseEntityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {

    UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);

    University universityDtoToUniversity(UniversityDto universityDto);

    UniversityDto universityToUniversityDto(University university);

    BaseEntity map(BaseEntityDto value);

    BaseEntityDto map(BaseEntity value);
}
