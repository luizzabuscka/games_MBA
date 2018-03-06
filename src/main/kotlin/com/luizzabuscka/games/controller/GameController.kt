package com.luizzabuscka.games.controller

import com.luizzabuscka.games.model.Game
import com.luizzabuscka.games.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController {

    @Autowired
    lateinit var gameService: GameService

    @GetMapping
    fun buscarTodos(): List<Game> {
        return gameService.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        return gameService.salvar(game)
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscarPor(@PathVariable(value = "titulo") titulo: String): List<Game> {
        return gameService.buscarPor(nome = titulo)
    }

    @DeleteMapping(value = "{id}")
    fun apagar(@PathVariable(value = "id") id: String) {
        gameService.apagar(id)
    }
}