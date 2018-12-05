package ladder.domain.generators

import ladder.domain.PLAYERS
import ladder.domain.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlayerGeneratorTest {
    @Test
    fun `플레이어 생성이 정상적으로 되었는지 확인`() {
        val players = PlayerGenerator.generator("Dave,Lee,Kim")
        assertThat(players).isEqualTo(PLAYERS)
    }
}
