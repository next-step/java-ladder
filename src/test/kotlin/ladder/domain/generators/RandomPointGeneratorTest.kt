package ladder.domain.generators

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPointGeneratorTest {
    @Test
    fun `랜덤 라인생성 사이즈 체크`() {
        val points = RandomPointGenerator.generator(5)
        assertThat(points).hasSize(5)
    }
}
