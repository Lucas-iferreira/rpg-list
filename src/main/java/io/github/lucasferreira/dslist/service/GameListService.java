package io.github.lucasferreira.dslist.service;

import io.github.lucasferreira.dslist.dto.GameListDTO;
import io.github.lucasferreira.dslist.entities.GameList;
import io.github.lucasferreira.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    @Autowired
    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> listDTOS = list.stream().map(GameListDTO::new).toList();
        return listDTOS;
    }

}
