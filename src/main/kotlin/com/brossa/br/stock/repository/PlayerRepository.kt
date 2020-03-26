package com.brossa.br.stock.repository
import com.brossa.br.stock.repository.model.Player
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface PlayerRepository : MongoRepository<Player, Int>