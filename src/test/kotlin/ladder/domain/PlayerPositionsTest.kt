package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class PlayerPositionsTest {
    private lateinit var playerPositions: PlayerPositions

    @Before
    fun setup() {
        playerPositions = PlayerPositions(PLAYERS, LADDER)
    }

    @Test
    fun `세번째 포지션값 확인`() {
        assertThat(playerPositions.size()).isEqualTo(3)
    }

    @Test
    fun `플레이어 결과 확인`() {
        val dave = playerPositions.get(Player("Dave"))
        val lee = playerPositions.get(Player("Lee"))
        val kim = playerPositions.get(Player("Kim"))
        assertThat(dave).isEqualTo(2)
        assertThat(lee).isEqualTo(0)
        assertThat(kim).isEqualTo(1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `존재하지 않는 유저 입력시 에러`() {
        playerPositions.get(Player("김아무개"))
    }
}