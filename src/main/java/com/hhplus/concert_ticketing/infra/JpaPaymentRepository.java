package com.hhplus.concert_ticketing.infra;

import com.hhplus.concert_ticketing.business.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByReservationId(Long reservationId);
    List<Payment> findByReservationIdAndStatusIs(Long reservationId, String status);
}
