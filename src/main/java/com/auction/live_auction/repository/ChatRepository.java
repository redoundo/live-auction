package com.auction.live_auction.repository;

import com.auction.live_auction.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * chat database repository
 */
@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Integer> {
    Optional<ChatEntity> findByRoomId(int roomId);

    @Query(value = "SELECT chat FROM ChatEntity chat WHERE chat.chatId=(SELECT entity.chatId FROM ChatEntity entity WHERE entity.roomId=:roomId)", nativeQuery = true)
    List<ChatEntity> findAllByRoomId(@Param("roomId") int roomId);

    @Transactional
    @Query(value = "DELETE FROM ChatEntity chat WHERE chat.chatId=(SELECT entity.chatId FROM ChatEntity entity WHERE entity.roomId=:roomId)", nativeQuery = true)
    void deleteAllChatByRoomId(@Param("roomId") int roomId);

}
