package com.auction.live_auction.repository;

import com.auction.live_auction.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * room repository
 */
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Transactional
    @Query(value = "INSERT INTO RoomEntity VALUES(:roomName)", nativeQuery = true)
    void createChatRoom(@Param("roomName") String roomName);

    @Query(value = "SELECT room.roomId, room.roomName FROM RoomEntity room WHERE room.roomName=:roomName", nativeQuery = true)
    RoomEntity findChatRoomByRoomName(@Param("roomName") String roomName);

}
