package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
