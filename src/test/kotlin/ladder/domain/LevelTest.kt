package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

class LevelTest {
    @Test
    fun `문자열로 사다리 높이 가져오기`() {
        assertThat(Level.findLevel("상").getHeight()).isEqualTo(20)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `없는 레벨 에러`() {
        Level.findLevel("초특등급")
    }

    @Test
    fun `레벨 가져오기`() {
        assertThat(Level.findLevel("상")).isEqualTo(Level.HIGH)
    }
}
