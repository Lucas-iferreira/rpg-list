package io.github.lucasferreira.dslist.service;

import io.github.lucasferreira.dslist.dto.GameMinDTO;
import io.github.lucasferreira.dslist.entities.Game;
import io.github.lucasferreira.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll(){
        List<Game> listGames = gameRepository.findAll();
        List<GameMinDTO> dtoList = listGames.stream().map(GameMinDTO::new).toList();

        return dtoList;
    }
}
