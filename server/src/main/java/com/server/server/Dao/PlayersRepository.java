package com.server.server.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.server.entity.Players;

public interface PlayersRepository extends JpaRepository<Players, Long> {

}
