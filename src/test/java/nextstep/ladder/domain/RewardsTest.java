package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RewardsTest {
    private Rewards rewards;

    @BeforeEach
    private void before() {
        rewards = Rewards.of("꽝", "5000", "꽝");
    }

    @Test
    void 생성_비교() {
        Rewards targetRewards = Rewards.from("꽝,5000,꽝");
        assertThat(targetRewards).isEqualTo(rewards);
    }

    @Test
    void 결과_미입력() {
        assertThatThrownBy(() -> {
            Rewards.from("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자수와_동일() {
        Members members = Members.from("poni,mouse,peace");
        assertThat(Rewards.of("꽝,5000,꽝", members)).isEqualTo(rewards);
    }

    @Test
    void 참가자수와_다름() {
        assertThatThrownBy(() -> {
            Members members = Members.from("poni,mouse,peace,dobi");
            Rewards.of("꽝,5000,꽝", members);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
