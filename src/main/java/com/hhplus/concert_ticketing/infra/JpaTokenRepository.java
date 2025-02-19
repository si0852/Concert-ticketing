package com.hhplus.concert_ticketing.infra;

import com.hhplus.concert_ticketing.business.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaTokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByUserId(Long userId);
}
