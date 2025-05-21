package io.github.lucasferreira.dslist.service;

import io.github.lucasferreira.dslist.dto.GameDTO;
import io.github.lucasferreira.dslist.dto.GameMinDTO;
import io.github.lucasferreira.dslist.entities.Game;
import io.github.lucasferreira.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //Estamos assegurando que não iremos realizar nenhum
    //tratamento de escrita, somente leitura
    //o que melhora o desempenho da aplicação
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> listGames = gameRepository.findAll();
        List<GameMinDTO> dtoList = listGames.stream().map(GameMinDTO::new).toList();

        return dtoList;
    }
}
