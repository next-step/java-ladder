package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DirectionTest {
    @Test
    fun `오른쪽 방향 생성`() {
        val direction = Direction.of(false, true)
        assertThat(direction.isRight()).isTrue()
    }

    @Test
    fun `왼쪽 방향 생성`() {
        val direction = Direction.of(true, false)
        assertThat(direction.isLeft()).isTrue()
    }

    @Test
    fun `현재 방향 생성`() {
        val direction = Direction.of(false, false)
        assertThat(direction.isCurrent()).isTrue()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `잘못된 방향 입력시 에러`() {
        Direction.of(true, true)
    }
}