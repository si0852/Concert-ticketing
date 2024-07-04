package com.hhplus.concert_ticketing.presentation.dto.request;

import lombok.Getter;

@Getter
public class PaymentRequest {

    Long reservation_id;
    Long amount;
}
