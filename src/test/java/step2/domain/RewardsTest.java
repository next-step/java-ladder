package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {

    @Test
    void 보상을_생성한다() {
        //given
        Rewards rewards = Rewards.of("꽝,5000,꽝,5000");
        //when & then
        assertThat(rewards).isEqualTo(Rewards.of("꽝,5000,꽝,5000"));
    }

    @Test
    void 보상을_찾는다() {
        //given
        Rewards rewards = Rewards.of("꽝,1000,꽝꽝,5000");
        //when & then
        assertThat(rewards.getBy(0)).isEqualTo("꽝");
        assertThat(rewards.getBy(1)).isEqualTo("1000");
        assertThat(rewards.getBy(2)).isEqualTo("꽝꽝");
        assertThat(rewards.getBy(3)).isEqualTo("5000");
    }

    @Test
    void 보상이_존재하지_않으면_IllegalArgumentException_이_발생한다() {
        //given
        Rewards rewards = Rewards.of("꽝,5000,꽝,5000");
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> rewards.getBy(4), "보상이 존재하지 않습니다.");
    }
}
