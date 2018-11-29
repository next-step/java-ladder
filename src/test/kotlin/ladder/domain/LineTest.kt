package ladder.domain

import org.assertj.core.api.Assertions.assertThat
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
        assertThat(line.drawLine()).isEqualTo("     |-----|     |")
    }

    @Test
    fun `라인 방향`() {
        assertThat(line.position(0)).isEqualTo(1)
        assertThat(line.position(1)).isEqualTo(-1)
        assertThat(line.position(2)).isEqualTo(0)
    }

    private fun dummyPoints() = arrayListOf(
            Point(false, true),
            Point(true, false),
            Point(false, false)
    )
}
