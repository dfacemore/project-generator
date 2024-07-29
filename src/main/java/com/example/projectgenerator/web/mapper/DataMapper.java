package com.example.projectgenerator.web.mapper;

import com.example.projectgenerator.model.Data;
import com.example.projectgenerator.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
