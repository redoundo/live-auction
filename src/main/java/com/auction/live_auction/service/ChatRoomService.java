package com.auction.live_auction.service;

import com.auction.live_auction.entity.ChatEntity;
import com.auction.live_auction.entity.RoomEntity;
import com.auction.live_auction.repository.ChatRepository;
import com.auction.live_auction.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRepository chatRepository;
    private final RoomRepository roomRepository;

    public ChatEntity saveChat(ChatEntity entity){
        // todo: 제대로 반환이 되는지 여부 확인 필수
        return chatRepository.save(entity);
    }

    public List<RoomEntity> allRoomList(){
        return roomRepository.findAll();
    }

    public List<ChatEntity> findChatMessagesByRoomId(int roomId){
        if (roomRepository.existsById(roomId)) return chatRepository.findAllByRoomId(roomId);
        else return null;
    }

    /**
     * 채팅 내용과 채팅방 모두 삭제
     * @param roomId 채팅방 id 
     */
    @Transactional
    public void deleteAllChatByRoomId(int roomId){
        chatRepository.deleteAllChatByRoomId(roomId); // 채팅 내용 모두 삭제
        roomRepository.deleteById(roomId); // 채팅방 삭제
    }

    /**
     * 채팅방 생성
     * @param roomName 채팅방 이름
     * @return 채팅방 정보
     */
    public RoomEntity createChatRoom(String roomName){
        roomRepository.createChatRoom(roomName);
        return roomRepository.findChatRoomByRoomName(roomName);
    }
}
