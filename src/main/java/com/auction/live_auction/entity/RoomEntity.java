package com.auction.live_auction.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * room table entity
 */
@Data
@Entity
@Table(name = "room")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId", nullable = false, unique = true)
    private int roomId;
    @Column(name = "roomName", nullable = false, unique = true)
    private String roomName;
}
