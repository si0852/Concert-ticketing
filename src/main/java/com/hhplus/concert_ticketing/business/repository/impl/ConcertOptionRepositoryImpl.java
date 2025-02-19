package com.hhplus.concert_ticketing.business.repository.impl;

import com.hhplus.concert_ticketing.business.entity.ConcertOption;
import com.hhplus.concert_ticketing.business.repository.ConcertOptionRepository;
import com.hhplus.concert_ticketing.infra.JpaConcertOptionRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ConcertOptionRepositoryImpl implements ConcertOptionRepository {

    private final JpaConcertOptionRepository jpaConcertOptionRepository;

    public ConcertOptionRepositoryImpl(JpaConcertOptionRepository jpaConcertOptionRepository) {
        this.jpaConcertOptionRepository = jpaConcertOptionRepository;
    }

    @Override
    public ConcertOption saveData(ConcertOption concertOption) {
        return jpaConcertOptionRepository.save(concertOption);
    }

    @Override
    public ConcertOption update(ConcertOption concertOption) {
        return jpaConcertOptionRepository.save(concertOption);
    }

    @Override
    public List<ConcertOption> getConcertOptionData(Long concertId) {
        return jpaConcertOptionRepository.findAllByConcertId(concertId);
    }

    @Override
    public List<LocalDateTime> getConcertDate(Long concertId) {
        return jpaConcertOptionRepository.findConcertDateByConcertId(concertId);
    }



}
