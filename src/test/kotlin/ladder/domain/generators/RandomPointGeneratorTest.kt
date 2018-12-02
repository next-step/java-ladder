package ladder.domain.generators

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RandomPointGeneratorTest {
    @Test
    fun `라인생성`() {
        val points = RandomPointGenerator.generator(10)
        assertThat(points).hasSize(10)
    }

    @Test
    fun `포인트 자동생성` () {
        val point = RandomPointGenerator.generator2(5)
        println(point)
    }
}
