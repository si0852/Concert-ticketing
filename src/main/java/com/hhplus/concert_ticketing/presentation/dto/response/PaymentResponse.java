package com.hhplus.concert_ticketing.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentResponse {
    Long reservation_id;
    Long amount;
    LocalDateTime paymentDate;

    @Builder
    public PaymentResponse(Long reservation_id, Long amount,
                           LocalDateTime paymentDate
    ) {
        this.reservation_id = reservation_id;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
}
