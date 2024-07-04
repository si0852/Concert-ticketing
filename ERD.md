## 1. ERD 다이어그램
![KakaoTalk_Photo_2024-07-04-23-13-33](https://github.com/si0852/Concert-ticketing/assets/64186698/52b4fac4-3439-4aea-9134-0324aa2f8d18)
## 2. Table Info
#### - CUSTOMER
- 사용자의 정보(이름, 잔액)을 관리하는 테이블

#### - TOKEN
- 사용자별 발급받은 토큰 정보를 관리하는 테이블
- CUSTOMER:TOKEN -> 1:1 관계  

#### - CONCERT
- 콘서트 정보(콘서트명)를 관리하는 테이블

#### - CONCERT_OPTION
- 콘서트의 디테일한 정보를 관리하는 테이블 (+ 콘서트 날짜, 가격 등)
- CONCERT:CONCERT_OPTION -> 1:N 관계

#### - SEAT
- 콘서트 좌석 정보 및 상태를 관리하는 테이블
- status[잠금, 열림] 상태에 따라 좌석 선택여부가 갈린다.

#### - RESERVATION
- 예약 정보를 관리하는 테이블
- status는 [예약중, 결제됨, 예약취소]로 표기된다.
- PAYMENT:RESERVATION -> 1:1 관계
- CUSTOMER:RESERVATION -> 1:N 관계
- SEAT:RESERVATION -> 1:N 관계

#### - PAYMENT
- 티켓 예약에 대한 결제 내역을 관리하는 테이블