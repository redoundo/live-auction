package com.auction.live_auction.controller;

import com.auction.live_auction.entity.ChatEntity;
import com.auction.live_auction.entity.RoomEntity;
import com.auction.live_auction.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class RoomController {

    private final ChatRoomService chatRoomService;

    /**
     * 채팅방 만들기
     * @param roomName 채팅방 이름. unique 해야 함.
     * @return 만들어진 채팅방 정보
     */
    @GetMapping(value = {"/create/chatroom"})
    public ResponseEntity<RoomEntity> createChattingRoom(@RequestParam(name = "roomName") String roomName){
        RoomEntity room = chatRoomService.createChatRoom(roomName);
        return ResponseEntity.ok(room);
    }

    /**
     * 존재하는 모든 채팅방 반환.
     * @return 채팅방 정보 리스트
     */
    @GetMapping(value = {"/get/chatroomList"})
    public ResponseEntity<List<RoomEntity>> allChatRoom(){
        return ResponseEntity.ok(chatRoomService.allRoomList());
    }

    /**
     * 채팅방 삭제
     * @param roomId 채팅방 아이디
     * @return true | exception
     */
    @GetMapping(value = {"/delete/chatroom"})
    public ResponseEntity<Boolean> deleteChatRoom(@RequestParam("roomId") int roomId){
        chatRoomService.deleteAllChatByRoomId(roomId);
        return ResponseEntity.ok(true);
    }
}
