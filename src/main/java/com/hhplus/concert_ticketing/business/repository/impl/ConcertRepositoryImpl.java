package com.hhplus.concert_ticketing.business.repository.impl;

import com.hhplus.concert_ticketing.business.entity.Concert;
import com.hhplus.concert_ticketing.business.repository.ConcertRepository;
import com.hhplus.concert_ticketing.infra.JpaConcertRepository;

public class ConcertRepositoryImpl implements ConcertRepository {

    private final JpaConcertRepository jpaConcertRepository;

    public ConcertRepositoryImpl(JpaConcertRepository jpaConcertRepository) {
        this.jpaConcertRepository = jpaConcertRepository;
    }

    @Override
    public Concert saveData(Concert concert) {
        return jpaConcertRepository.save(concert);
    }

    @Override
    public Concert getConcertData(Long concertId) {
        return jpaConcertRepository.findById(concertId).orElse(null);
    }
}
