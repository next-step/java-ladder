package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class LadderResultTest {
    private lateinit var ladderResult: LadderResult

    @Before
    fun setup() {
        ladderResult = LadderResult(dummyRewards(), dummyPlayerPositions())
    }

    @Test
    fun `모든 플레이어 결과 얻기`() {
        val result = ladderResult.showResult(LadderResult.ALL)
        assertThat(result).isEqualTo("Dave : 꽝\nLee : 1000\nKim : 꽝")
    }

    @Test
    fun `한명의 플레이어 결과 얻기`() {
        val result = ladderResult.showResult("Lee")
        assertThat(result).isEqualTo("1000")
    }

    private fun dummyRewards() = Rewards("꽝,1000,꽝")

    private fun dummyPlayerPositions() =
            PlayerPositions(arrayListOf(
                Player("Dave"),
                Player("Lee"),
                Player("Kim"))
        )
}
