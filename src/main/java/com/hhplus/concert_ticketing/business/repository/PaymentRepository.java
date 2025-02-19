package com.hhplus.concert_ticketing.business.repository;

import com.hhplus.concert_ticketing.business.entity.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment saveData(Payment payment);

    Payment updateData(Payment payment);

    List<Payment> getPaymentData(Long reservationId);

    List<Payment> getPaymentData(Long reservationId, String status);
}
