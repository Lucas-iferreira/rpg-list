package io.github.lucasferreira.dslist.service;

import io.github.lucasferreira.dslist.dto.GameListDTO;
import io.github.lucasferreira.dslist.entities.GameList;
import io.github.lucasferreira.dslist.projections.GameMinProjection;
import io.github.lucasferreira.dslist.repository.GameListRepository;
import io.github.lucasferreira.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;
    private GameRepository gameRepository;

    @Autowired
    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> listDTOS = list.stream().map(GameListDTO::new).toList();
        return listDTOS;
    }

    @Transactional
    public void move(Long listId, int soucerIndex, int targetIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(soucerIndex);
        list.add(targetIndex,obj);

        int min = Math.min(soucerIndex, targetIndex);
        int max = Math.max(soucerIndex, targetIndex);

        for(int i=min; i<=max;i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
