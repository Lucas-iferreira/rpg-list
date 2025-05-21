package io.github.lucasferreira.dslist.controllers;

import io.github.lucasferreira.dslist.dto.GameListDTO;
import io.github.lucasferreira.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;

    @Autowired
    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return  gameListService.findAll();
    }
}
