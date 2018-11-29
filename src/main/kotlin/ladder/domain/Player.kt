package ladder.domain

class Player {
    var name: String
        private set

    constructor(name: String) {
        if (name.length > MAX_NAME_SIZE) {
            throw IllegalArgumentException("플레이어 이름이 너무 깁니다.")
        }
        this.name = name
    }



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Player
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int = name.hashCode()

    override fun toString(): String {
        return "Player(name='$name')"
    }

    companion object {
        const val MAX_NAME_SIZE = 5
    }
}
