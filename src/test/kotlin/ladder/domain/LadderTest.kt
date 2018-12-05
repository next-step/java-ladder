package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class LadderTest {
    private lateinit var ladder: Ladder

    @Before
    fun setup() {
        ladder = Ladder(PLAYERS, 5)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `사다리 길이 1보다 작으면 에러`() {
        Ladder(PLAYERS, 0)
    }

    @Test
    fun `이름이 잘 들어갔는지 확인`() {
        val isIncludeNames = ladder.drawLadder().contains("Dave Lee Kim")
        assertThat(isIncludeNames).isTrue()
    }
}
