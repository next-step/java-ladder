package ladder.domain

import org.junit.Test

class PlayerTest {

    @Test(expected = IllegalArgumentException::class)
    fun `이름이 5자 초과인 플레이어 생성오류`() {
        Player("김도레미파솔")
    }
}
