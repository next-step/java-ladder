package ladder.domain.generators

import ladder.domain.Level
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPointGeneratorTest {
    @Test
    fun `포인트 자동생성` () {
        val points = RandomPointGenerator.generator(5, Level.MEDIUM)
        assertThat(points).hasSize(5)
    }
}
