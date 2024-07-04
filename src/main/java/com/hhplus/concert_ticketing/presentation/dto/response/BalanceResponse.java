package com.hhplus.concert_ticketing.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BalanceResponse {
    Long userId;
    Long totalBalance;

    @Builder
    public BalanceResponse(Long userId, Long totalBalance) {
        this.userId = userId;
        this.totalBalance = totalBalance;
    }
}
