package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.BaseDto;
import com.usman.hostelmanagementsystem.model.AbstractModel;

import java.util.List;

public interface BaseMapper<D extends BaseDto, E extends AbstractModel> {
    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
