package com.hhplus.concert_ticketing.presentation.dto.response;

import com.hhplus.concert_ticketing.presentation.dto.status.ReservationStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationResponse {

    Long userId;
    Long seatId;
    ReservationStatus status;
    LocalDateTime createdAt;

    @Builder
    public ReservationResponse(Long userId, Long seatId,
                               ReservationStatus status,
                               LocalDateTime createdAt) {
        this.userId = userId;
        this.seatId = seatId;
        this.status = status;
        this.createdAt = createdAt;
    }
}
