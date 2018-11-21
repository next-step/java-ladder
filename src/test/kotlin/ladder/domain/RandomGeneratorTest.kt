package ladder.domain

import org.junit.Test

class RandomGeneratorTest {
    @Test
    fun `랜덤 라인생성`() {
        val points = RandomGenerator.generator(5)
        points.forEach {
            println(it)
        }
    }
}