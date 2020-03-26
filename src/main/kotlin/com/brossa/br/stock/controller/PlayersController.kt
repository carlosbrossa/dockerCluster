package com.brossa.br.stock.controller

import com.brossa.br.stock.repository.model.Player
import com.brossa.br.stock.service.PlayerService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.concurrent.thread

@RestController
@RequestMapping("/players")
class PlayersController(
        private val playerService: PlayerService
){

    fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
    private val log = loggerFor(javaClass)


    @GetMapping("/seed")
    fun insert(): String {
        log.info("Players creating  ................................... ")
        playerService.insert()
        log.info("Players are created !!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        return "players inserted"
    }

    @GetMapping
    fun get(): MutableList<Player> {
        log.info("Players searching  ...................................")
        val list = playerService.list()
        log.info("Players Found !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        return list
    }

}