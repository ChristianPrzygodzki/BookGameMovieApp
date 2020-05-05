package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
