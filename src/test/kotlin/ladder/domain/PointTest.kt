package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PointTest {
    @Test(expected = IllegalArgumentException::class)
    fun `포인트 생성 오류`() {
        Point.of(true, true)
    }

    @Test
    fun `첫번째 라인 생성`() {
        val point = Point.first(false)
        assertThat(point).isEqualTo(Point.of(false, false))
    }
}
