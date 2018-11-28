package ladder.domain

import org.assertj.core.api.Assertions
import org.junit.Test

class DirectionTest {
    @Test
    fun `오른쪽`() {
        val right = Direction.findDirection(Point(false, true))
        Assertions.assertThat(right).isEqualTo(Direction.RIGHT)
    }

    @Test
    fun `왼쪽`() {
        val left = Direction.findDirection(Point(true, false))
        Assertions.assertThat(left).isEqualTo(Direction.LEFT)
    }

    @Test
    fun `제자리`() {
        val current = Direction.findDirection(Point(false, false))
        Assertions.assertThat(current).isEqualTo(Direction.CURRENT)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `비정상적인 방향 생성에러`() {
        Direction.findDirection(Point(true, true))
    }
}
