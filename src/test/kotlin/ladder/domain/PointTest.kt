package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PointTest {

    @Test
    fun `포인트 왼쪽으로 이동`() {
        val point2 = Point(DEFAULT_POSITION, DIRECTION_LEFT)
        assertThat(point2.move()).isEqualTo(0)
    }

    @Test
    fun `포인트 오른쪽으로 이동`() {
        val point2 = Point(DEFAULT_POSITION, DIRECTION_RIGHT)
        assertThat(point2.move()).isEqualTo(2)
    }

    @Test
    fun `포인트 이동변화 없음`() {
        val point2 = Point(DEFAULT_POSITION, DIRECTION_CURRENT)
        assertThat(point2.move()).isEqualTo(1)
    }

    @Test
    fun `포인트 next` () {
        val point: Point = Point.first(true)
        val points = arrayListOf(point)
        points.add(points[0].next(false))
        assertThat(points[1]).isEqualTo(Point(1, DIRECTION_LEFT))
    }

    companion object {
        private const val DEFAULT_POSITION = 1
        private val DIRECTION_LEFT = Direction.of(true, false)
        private val DIRECTION_RIGHT = Direction.of(false, true)
        private val DIRECTION_CURRENT = Direction.of(false, false)
    }
}
