package stelmach.bartosz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stelmach.bartosz.entity.Game;
import stelmach.bartosz.entity.MovePlaceholder;
import stelmach.bartosz.repository.GameRepository;
import stelmach.bartosz.repository.MoveRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    MoveRepository moveRepository;
    @Autowired
    GameRepository gameRepository;

    public Game getGame(int id) {
        Game game = gameRepository.findById(id).get();
        List<MovePlaceholder> movePlaceholderList = moveRepository.findByGame(game);
        List<String> moves = movePlaceholderList.stream()
                .map(MovePlaceholder::getNotation)
                .collect(Collectors.toList());
        game.setMoves(moves);
        return game;
    }
}
