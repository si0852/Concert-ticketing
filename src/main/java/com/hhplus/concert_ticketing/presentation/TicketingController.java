package com.hhplus.concert_ticketing.presentation;

import com.hhplus.concert_ticketing.presentation.dto.request.BalanceRequest;
import com.hhplus.concert_ticketing.presentation.dto.request.PaymentRequest;
import com.hhplus.concert_ticketing.presentation.dto.request.ReservationRequest;
import com.hhplus.concert_ticketing.presentation.dto.response.BalanceResponse;
import com.hhplus.concert_ticketing.presentation.dto.response.PaymentResponse;
import com.hhplus.concert_ticketing.presentation.dto.response.ReservationResponse;
import com.hhplus.concert_ticketing.presentation.dto.response.TokenResponse;
import com.hhplus.concert_ticketing.presentation.dto.status.TokenStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TicketingController {


    // 유저 토큰 발급 API
    // http://localhost:8080/api/token
    @PostMapping("/api/token")
    public ResponseEntity<TokenResponse> generateToken(@RequestParam String userId) {
        String token = "This_is_Token_mocked_token_for_" + userId; // 임시토큰형식
        TokenStatus status = TokenStatus.ACTIVE;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expiresAt = createdAt.plusHours(1); // 만료시간이 1시간

        TokenResponse response = TokenResponse.builder()
                .user_id(userId)
                .token(token)
                .status(status)
                .created_at(createdAt)
                .expires_at(expiresAt)
                .build();

        return ResponseEntity.ok(response);
    }


    // 예약 가능 날짜 조회
    // http://localhost:8080/api/concert/1/available-dates
    @GetMapping("/api/concert/{concertOptionId}/available-dates")
    public ResponseEntity<List<String>> getAvailableDates(@PathVariable String concertOptionId) {
        log.info("you entered concertOptionId :: " + concertOptionId);
        List<String> dates = new ArrayList<>();
        dates.add("2024-07-10");
        dates.add("2024-07-11");
        dates.add("2024-07-12");
        dates.add("2024-07-13");
        dates.add("2024-07-14");

        return ResponseEntity.ok(dates);
    }


    // 예약 가능 좌석 조회
    // /api/concert/1/available-seats?date=2024-07-05
    @GetMapping("/api/concert/{concertOptionId}/available-seats")
    public ResponseEntity<List<String>> getAvailableSeats(
            @PathVariable String concertOptionId,
            @RequestParam String date
    ) {
        log.info("you entered concertOptionId :: " + concertOptionId);
        log.info("you entered date :: " + date);
        List<String> seats = new ArrayList<>();
        seats.add("A1");
        seats.add("A2");
        seats.add("A3");

        return ResponseEntity.ok(seats);
    }


    // 좌석 예약 요청 API
    /*
    http://localhost:8080/api/reserve
    {
    "userId": 12345,
    "seatId": 67890,
    "status": "WAITING"
    }
    raw 타입 Json으로 꼭!!
    * */
    @PostMapping("/api/reserve")
    public ResponseEntity<ReservationResponse> reserveSeat(
            @RequestBody ReservationRequest request) {
        ReservationResponse response = ReservationResponse.builder()
                .userId(request.getUserId())
                .seatId(request.getSeatId())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }


    // 잔액 충전
    /*
    * http://localhost:8080/api/balance/charge
    * {
        "userId": 12345,
        "chargeBalance": 100000
      }
    * */
    @PatchMapping("/api/balance/charge")
    public ResponseEntity<BalanceResponse> chargeBalance(@RequestBody BalanceRequest request) {

        return ResponseEntity.ok(BalanceResponse.builder()
                .userId(request.getUserId())
                .totalBalance(request.getChargeBalance()+1000)
                .build());
    }

    // 잔액 조회
    // http://localhost:8080/api/balance?userId=1
    @GetMapping("/api/balance")
    public ResponseEntity<BalanceResponse> getBalance(@RequestParam Long userId) {
        return ResponseEntity.ok(BalanceResponse.builder()
                .userId(userId)
                .totalBalance(10000L)
                .build());
    }//getBalance

    // 결제 API
    /*
    * http://localhost:8080/api/pay
    * {
        "reservation_id" : 1,
        "amount" : 10000
      }
    * */
    @PostMapping("/api/pay")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(PaymentResponse.builder()
                .reservation_id(request.getReservation_id())
                .amount(request.getAmount())
                .paymentDate(LocalDateTime.now())
                .build());
    }//processPayment

}
