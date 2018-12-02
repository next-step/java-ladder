package ladder.domain

import org.junit.Before
import org.junit.Test

class LineTest {
    private lateinit var line: Line

    @Before
    fun setup() {
        line = Line(dummyPoints())
    }

    @Test
    fun `라인 생성`() {
        println(line.drawLine())
    }

    @Test
    fun `라인 방향`() {
//        assertThat(line.position(0)).isEqualTo(1)
//        assertThat(line.position(1)).isEqualTo(-1)
//        assertThat(line.position(2)).isEqualTo(0)
    }

    private fun dummyPoints() = arrayListOf(
            Point(0, Direction.first(true)),
            Point(1, Direction.of(true, false))
    )

    private fun dummyPoints2() = arrayListOf(
            Point(0, Direction.first(true)),
            Point(1, Direction.of(true, false)),
            Point(2, Direction.of(false, false)),
            Point(3, Direction.of(false, true))
    )
}
