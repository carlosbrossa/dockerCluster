package com.brossa.br.stock.service

import com.brossa.br.stock.repository.PlayerRepository
import com.brossa.br.stock.repository.model.Player
import org.springframework.stereotype.Service

@Service
class PlayerService(
        private val playerRepository: PlayerRepository
) {



    fun insert(){

        val listOf = listOf<Player>(
        Player(name= "Cristiano Ronaldo", nationality = "Portugal", team = "Juventus"),
        Player(name= "Cristiano Ronaldo", nationality = "Portugal", team = "Juventus"),
        Player(name= "Cristiano Ronaldo", nationality = "Portugal", team = "Juventus"))

        playerRepository.saveAll(listOf)
    }

    fun list(): MutableList<Player> {
        return playerRepository.findAll()
    }

}