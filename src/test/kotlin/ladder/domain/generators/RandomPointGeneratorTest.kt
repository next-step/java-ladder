package ladder.domain.generators

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPointGeneratorTest {
    @Test
    fun `라인생성`() {
        val points = RandomPointGenerator.generator(10)
        assertThat(points).hasSize(10)
    }
}
