package stelmach.bartosz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stelmach.bartosz.entity.Game;
import stelmach.bartosz.repository.GameRepository;

@Service
public class GameCreator {
    @Autowired
    private GameRepository gameRepository;
    public Game createGame(String firstPlayerName, String secondPlayerName, boolean areColoursRandom) {
        Game game = new Game(firstPlayerName, secondPlayerName);
        gameRepository.save(game);
        return game;

//        if (!areColoursRandom) {
//
//        }
//        else return null;
    }
}
