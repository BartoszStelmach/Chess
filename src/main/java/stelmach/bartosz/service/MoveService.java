package stelmach.bartosz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import stelmach.bartosz.entity.Game;
import stelmach.bartosz.entity.MovePlaceholder;
import stelmach.bartosz.repository.GameRepository;
import stelmach.bartosz.repository.MoveRepository;

@Service
public class MoveService {

	@Autowired
	MoveRepository moveRepository;

	@Autowired
	GameRepository gameRepository;

	public void playMove(int id, String colour, String move) {
		Game game = gameRepository.getReferenceById(id);
		MovePlaceholder movePlaceholder = new MovePlaceholder(game, move);
		moveRepository.save(movePlaceholder);
	}

}
