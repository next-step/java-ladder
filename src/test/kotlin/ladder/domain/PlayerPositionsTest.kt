package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class PlayerPositionsTest {
    private lateinit var playerPositions: PlayerPositions

    @Before
    fun setup() {
        playerPositions = PlayerPositions(dummyPlayers())
    }

    @Test
    fun `세번째 포지션값 확인`() {
        val position = playerPositions.get(Player("Kim"))
        assertThat(position).isEqualTo(2)
    }

    @Test
    fun `플레이어 비교`() {
        assertThat(playerPositions.allPlayers()).isEqualTo(dummyPlayers())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `사다리 범위 벗어난 포지션`() {
        playerPositions.move(Player("Dave"), -1)
    }

    @Test
    fun `포지션 변경`() {
        playerPositions.move(Player("Dave"), 1)
        playerPositions.move(Player("Dave"), 1)
        val position = playerPositions.get(Player("Dave"))
        assertThat(position).isEqualTo(2)
    }

    private fun dummyPlayers() = arrayListOf(Player("Dave"), Player("Lee"), Player("Kim"))
}