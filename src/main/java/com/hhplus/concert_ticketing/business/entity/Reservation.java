package com.hhplus.concert_ticketing.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long reservationId;

    @NotNull
    Long userId;
    @NotNull
    Long seatId;
    @NotBlank
    String status; // 예약중, 결제됨, 예약취소
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Reservation(Long userId, Long seatId, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.seatId = seatId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
