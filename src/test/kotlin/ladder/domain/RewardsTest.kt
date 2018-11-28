package ladder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RewardsTest {
    @Test
    fun `리워드값 체크`() {
        val rewards = Rewards("꽝,100,200,꽝")
        assertThat(rewards.get(2)).isEqualTo("200")
    }
}
