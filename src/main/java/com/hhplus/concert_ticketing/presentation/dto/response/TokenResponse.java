package com.hhplus.concert_ticketing.presentation.dto.response;

import com.hhplus.concert_ticketing.presentation.dto.status.TokenStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TokenResponse {

    String          user_id;
    String          token;
    TokenStatus     status;
    LocalDateTime   created_at;
    LocalDateTime   expires_at;

    @Builder
    public TokenResponse(String user_id,
                         String token,
                         TokenStatus status,
                         LocalDateTime created_at,
                         LocalDateTime expires_at) {
        this.user_id = user_id;
        this.token = token;
        this.status = status;
        this.created_at = created_at;
        this.expires_at = expires_at;
    }
}
