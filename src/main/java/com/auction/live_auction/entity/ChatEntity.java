package com.auction.live_auction.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * chat database table
 */
@Data
@Entity
@Table(name = "chat")
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "chatId")
    private int chatId;
    @Column(nullable = false, name = "roomId")
    private int roomId;
    @Column(nullable = false, name = "message")
    private String message;
    @Column(nullable = false, name = "sender")
    private String sender;

    @Column(nullable = false, name = "sendDateTime", updatable = false)
    @CreatedDate
    private LocalDateTime sendDateTime;
}
