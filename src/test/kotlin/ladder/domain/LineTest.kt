package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LineTest {
    @Test
    fun `라인 생성`() {
        val line = Line(arrayListOf(false, true, false))
        assertThat(line.drawLine()).isEqualTo("     |-----|     |")
    }
}
