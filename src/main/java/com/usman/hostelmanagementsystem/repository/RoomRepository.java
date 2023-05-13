package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("from Room  room where room.isReady=true and  room.roomCapacity<5")
    Page<Room> findRoomIfReady(Pageable pageable);

    Optional<Room> findRoomByRoomNumber(String roomNumber);

}
