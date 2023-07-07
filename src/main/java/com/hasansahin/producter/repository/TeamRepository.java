package com.hasansahin.producter.repository;

import com.hasansahin.producter.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
