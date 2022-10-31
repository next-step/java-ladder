package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

public class RewardsTest {

    @Test
    void results() {
        Rewards rewards = new Rewards("3000", "꽝", "4000");

        assertThat(rewards.results()).containsExactly(new LadderTextInput("3000"), new LadderTextInput("꽝"), new LadderTextInput("4000"));
    }

    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    void result() {
        Rewards rewards = new Rewards("3000", "꽝", "4000");

        assertThat(rewards.result(new Point(1, 0))).isEqualTo(new LadderTextInput("꽝"));
    }
}
