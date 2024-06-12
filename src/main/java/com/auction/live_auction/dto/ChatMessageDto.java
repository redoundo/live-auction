package com.auction.live_auction.dto;

import lombok.*;

/**
 * socket 에서 받는 실제 내용
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ChatMessageDto {
    private String message;
    private String sender;
}
