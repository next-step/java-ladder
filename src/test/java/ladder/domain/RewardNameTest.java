package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardNameTest {
    @Test
    @DisplayName("보상 이름을 생성한다")
    void create() {
        RewardName rewardName = new RewardName("꽝");
        RewardName expected = new RewardName("꽝");
        RewardName notEqualExpected = new RewardName("3000");

        assertThat(rewardName).isEqualTo(expected);
        assertThat(rewardName).isNotEqualTo(notEqualExpected);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void value() {
        RewardName rewardName = new RewardName("꽝");
        String actual = rewardName.value();
        String expected = "꽝";

        assertThat(actual).isEqualTo(expected);
    }

}
