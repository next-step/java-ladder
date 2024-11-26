package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    @DisplayName("보상을 생성한다")
    void create() {
        Reward reward = new Reward("꽝", 0, 5);
        Reward expected = new Reward(new RewardName("꽝"), new Position(0, 5));

        assertThat(reward).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void name() {
        Reward reward = new Reward("꽝", 0, 5);
        String actual = reward.name();
        String expected = "꽝";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어와 Position 동등 비교: 일치")
    void isEqualPosition_일치() {
        Player player = new Player(new PlayerName("pobi"), new Position(1, 5));
        Reward reward = new Reward("꽝", 1,5);

        boolean actual = reward.isEqualPosition(player);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("플레이어와 Position 동등 비교: 불일치")
    void isEqualPosition_불일치() {
        Player player = new Player(new PlayerName("pobi"), new Position(1, 5));
        Reward reward = new Reward("꽝", 2,5);

        boolean actual = reward.isEqualPosition(player);
        assertThat(actual).isFalse();
    }
}
