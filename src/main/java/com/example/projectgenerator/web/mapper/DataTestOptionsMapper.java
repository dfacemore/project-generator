package com.example.projectgenerator.web.mapper;

import com.example.projectgenerator.model.test.DataTestOptions;
import com.example.projectgenerator.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper
        extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
