package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class LadderResultTest {
    private lateinit var ladderResult: LadderResult

    @Before
    fun setup() {
        ladderResult = LadderResult(REWARDS, PLAYER_POSITIONS)
    }

    @Test
    fun `모든 플레이어 결과 얻기`() {
        val result = ladderResult.showResult(LadderResult.ALL)
        assertThat(result).isEqualTo("Dave : 꽝\nLee : 꽝\nKim : 1000")
    }

    @Test
    fun `한명의 플레이어 결과 얻기`() {
        val result = ladderResult.showResult("Kim")
        assertThat(result).isEqualTo("1000")
    }
}
