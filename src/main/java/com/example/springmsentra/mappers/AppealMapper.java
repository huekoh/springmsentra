package com.example.springmsentra.mappers;

import com.example.springmsentra.entities.Appeal;
import com.example.springmsentra.model.dto.AppealDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AppealMapper {
    Appeal AppealDtoToAppeal(AppealDTO appealDto);

    AppealDTO AppealToAppealDto(Appeal appeal);
}
