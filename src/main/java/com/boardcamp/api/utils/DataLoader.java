package com.boardcamp.api.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.repositories.GameRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

	private final GameRepository gameRepository;

	public DataLoader(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	public void run(ApplicationArguments args) {
		List<GameModel> games = Arrays.asList(
				new GameModel("banana", "banana", 10L, 25L),
				new GameModel("banana", "banana", 10L, 25L),
				new GameModel("banana", "banana", 10L, 25L));

		gameRepository.saveAll(games);
	}
}
