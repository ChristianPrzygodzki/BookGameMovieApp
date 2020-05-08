package com.przygodzki.bgm_app.repository;

import com.przygodzki.bgm_app.entity.Book;
import com.przygodzki.bgm_app.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    default List<Game> findByTitle(String title) {
        return this.findAll().stream().filter(g -> g.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }
}
