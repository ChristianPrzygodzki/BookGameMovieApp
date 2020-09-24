package com.przygodzki.bgm_app.service.recomendation;

import com.przygodzki.bgm_app.service.BookService;
import com.przygodzki.bgm_app.service.GameService;
import com.przygodzki.bgm_app.service.MovieService;
import com.przygodzki.bgm_app.to.BookTo;
import com.przygodzki.bgm_app.to.CommonTo;
import com.przygodzki.bgm_app.to.GameTo;
import com.przygodzki.bgm_app.to.MovieTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomRecommendationProvider implements RecommendationProvider {

    private final BookService bookService;
    private final GameService gameService;
    private final MovieService movieService;
    private List<CommonTo> possibleRecomendations;

    @Autowired
    public RandomRecommendationProvider(BookService bookService, GameService gameService, MovieService movieService) {
        this.bookService = bookService;
        this.gameService = gameService;
        this.movieService = movieService;
    }


    @Override
    public CommonTo giveRecommendation() {
        getAllHighlyRatedProducts();
        if(possibleRecomendations.size()==0){
            throw new NoSuchElementException("There is nothing worth recomendation.");
        }
        return possibleRecomendations.get(ThreadLocalRandom.current().nextInt(0, possibleRecomendations.size()));
    }

    private List<CommonTo> getAllHighlyRatedProducts(){
        for(BookTo book : bookService.findAll()){
            if(book.getRate() >= 7){
                possibleRecomendations.add(book);
            }
        }
        for(GameTo game : gameService.findAll()){
            if(game.getRate() >= 7){
                possibleRecomendations.add(game);
            }
        }
        for(MovieTo movie : movieService.findAll()){
            if(movie.getRate() >= 7){
                possibleRecomendations.add(movie);
            }
        }
        return possibleRecomendations;
    }
}
