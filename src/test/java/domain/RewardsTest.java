package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    @DisplayName("특정 보상의 위치를 구한다.")
    @Test
    void test01() {
        Reward reward1 = new Reward("1000");
        Reward reward2 = new Reward("1000");
        Reward reward3 = new Reward("1000");
        Rewards rewards = new Rewards(List.of(reward1, reward2, reward3));

        assertThat(rewards.position(reward1)).isEqualTo(new Position(0, 0));
    }
}
