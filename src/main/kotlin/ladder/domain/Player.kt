package ladder.domain

class Player {
    private var name: String

    constructor(name: String) {
        if(name.length  > MAX_NAME_SIZE) {
            throw IllegalArgumentException("플레이어 이름이 너무 깁니다.")
        }
        this.name = name
    }

    override fun toString(): String {
        return "Player(name='$name')"
    }

    companion object {
        const val MAX_NAME_SIZE = 5
    }
}
