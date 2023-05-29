package com.server.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.bo.PlayersBo;
import com.server.server.entity.Players;

@RestController
@RequestMapping("/players")
public class PlayersController {
    @Autowired
    private PlayersBo playersBo;

    @GetMapping("/get")
    public List<Players> getAllPlayers() {
        return playersBo.getAllPlayers();

    }

    @PostMapping("/post")
    public ResponseEntity<Players> createPlayers(@RequestBody Players players) {
        return new ResponseEntity<Players>(playersBo.createPlayers(players), HttpStatus.CREATED);
    }

}
