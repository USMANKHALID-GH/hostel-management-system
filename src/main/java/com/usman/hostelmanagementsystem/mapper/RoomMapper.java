package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.RoomDto;
import com.usman.hostelmanagementsystem.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends  BaseMapper<RoomDto, Room> {

    Room toEntity(RoomDto dto);
    RoomDto toDto(Room entity);

}
