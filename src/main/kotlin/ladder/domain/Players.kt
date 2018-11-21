package ladder.domain

class Players {
    var players: ArrayList<Player>
        private set

    private constructor(players: ArrayList<Player>) {
        if (players.isEmpty()) {
            throw IllegalArgumentException("플레이어가 없습니다.")
        }

        this.players = players
    }

    companion object {
        fun ofComma(value: String): Players {
            val players = value.split(",")
                    .map { Player(it) }
                    .toCollection(ArrayList())
            return Players(players)
        }
    }
}
