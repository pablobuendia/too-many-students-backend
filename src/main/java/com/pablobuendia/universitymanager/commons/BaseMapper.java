package com.pablobuendia.universitymanager.commons;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseMapper {

    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    BaseEntity map(BaseEntityDto value);

    BaseEntityDto map(BaseEntity value);
}
