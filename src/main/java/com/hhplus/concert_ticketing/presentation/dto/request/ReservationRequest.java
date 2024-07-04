package com.hhplus.concert_ticketing.presentation.dto.request;

import com.hhplus.concert_ticketing.presentation.dto.status.ReservationStatus;
import lombok.Getter;

@Getter
public class ReservationRequest {
    Long userId;
    Long seatId;
    ReservationStatus status;
}
