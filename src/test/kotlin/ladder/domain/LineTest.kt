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

    private fun dummyPoints() = arrayListOf(
            Point(false, true),
            Point(true, false)
    )
}
