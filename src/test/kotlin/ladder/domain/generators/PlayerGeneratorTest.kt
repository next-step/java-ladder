package ladder.domain.generators

import ladder.domain.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlayerGeneratorTest {
    @Test
    fun `플레이어 생성이 정상적으로 되었는지 확인`() {
        val players = PlayerGenerator.generator("A,B,C,D,E")
        assertThat(players).isEqualTo(dummyPlayers())
    }

    private fun dummyPlayers() = arrayListOf(
            Player("A"),
            Player("B"),
            Player("C"),
            Player("D"),
            Player("E"))
}
