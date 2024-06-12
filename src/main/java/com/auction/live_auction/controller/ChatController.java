package com.auction.live_auction.controller;

import com.auction.live_auction.dto.ChatMessageDto;
import com.auction.live_auction.entity.ChatEntity;
import com.auction.live_auction.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * stomp message 컨트롤러
 */
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomService chatRoomService;

    @MessageMapping("{roomId}")
    @SendTo("/chat/{roomId}")
    public ChatEntity sendMessage(@DestinationVariable int roomId, ChatMessageDto dto){
        ChatEntity entity = ChatEntity
                .builder()
                .roomId(roomId)
                .message(dto.getMessage())
                .sender(dto.getSender())
                .build();
        return chatRoomService.saveChat(entity);
    }


}
