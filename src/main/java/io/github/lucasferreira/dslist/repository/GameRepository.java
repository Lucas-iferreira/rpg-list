package io.github.lucasferreira.dslist.repository;

import io.github.lucasferreira.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
