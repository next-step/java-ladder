package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class LadderTest {
    private lateinit var ladder: Ladder

    @Before
    fun setup() {
        ladder = Ladder(dummyPlayers(), 3)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `사다리 길이 1보다 작으면 에러`() {
        Ladder(dummyPlayers(), 0)
    }

    @Test
    fun `이름이 잘 들어갔는지 확인`() {
        val isIncludeNames = ladder.drawLadder().contains("Dave Gib Mlb")
        assertThat(isIncludeNames).isTrue()
    }

    private fun dummyPlayers() = arrayListOf(Player("Dave"), Player("Gib"), Player("Mlb"))
}
