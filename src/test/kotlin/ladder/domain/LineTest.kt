package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class LineTest {
    private lateinit var line: Line

    @Before
    fun setup() {
        line = Line(POSITION_ONE)
    }

    @Test
    fun `라인 생성`() {
        assertThat(line.drawLine()).isEqualTo("     |-----|     |     ")
    }

    @Test
    fun `오른쪽 방향으로 이동하면 1증가`() {
        assertThat(line.move(0)).isEqualTo(1)
    }

    @Test
    fun `왼쪽 방향으로 이동하면 1감소`() {
        assertThat(line.move(1)).isEqualTo(0)
    }

    @Test
    fun `방향 이동 없을때 이동변화 없음`() {
        assertThat(line.move(2)).isEqualTo(2)
    }
}
