package stelmach.bartosz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stelmach.bartosz.entity.Game;
import stelmach.bartosz.service.GameCreator;
import stelmach.bartosz.service.GameService;
import stelmach.bartosz.service.MoveService;

@RestController

public class ChessController {

	@Autowired
	GameCreator gameCreator;

	@Autowired
	GameService gameService;

	@Autowired
	MoveService moveService;

	@PostMapping("/start")
	public Game startGame(@RequestParam String firstPlayerName, @RequestParam String secondPlayerName,
			@RequestParam boolean areColoursRandom) {
		return gameCreator.createGame(firstPlayerName, secondPlayerName, areColoursRandom);
	}

	@GetMapping("/getGame")
	public Game getGame(@RequestParam int id) {
		return gameService.getGame(id);
	}

	@PostMapping("/playMove")
	public void playMove(@RequestParam int id, @RequestParam String colour, @RequestParam String move) {
		moveService.playMove(id, colour, move);
	}

}
