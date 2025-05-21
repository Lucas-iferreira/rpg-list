package io.github.lucasferreira.dslist.controllers;

import io.github.lucasferreira.dslist.dto.GameDTO;
import io.github.lucasferreira.dslist.dto.GameMinDTO;
import io.github.lucasferreira.dslist.entities.Game;
import io.github.lucasferreira.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameControllers {

    private GameService gameService;

    @Autowired
    public GameControllers(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

}
