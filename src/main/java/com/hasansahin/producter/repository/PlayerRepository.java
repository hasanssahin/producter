package com.hasansahin.producter.repository;

import com.hasansahin.producter.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
