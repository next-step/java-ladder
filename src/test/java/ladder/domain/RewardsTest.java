package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Rewards 클래스 테스트")
public class RewardsTest {

    private final String rewardName = "꽝";
    private final String rewardNames = rewardName + ",5000,꽝,3000";
    private final List<String> rewards = Arrays.stream(rewardNames.split(",")).collect(Collectors.toList());

    @DisplayName("여러 Reward를 생성 할 수 있다.")
    @Test
    void create() {
        Rewards actual = new Rewards(rewards, 4);
        assertThat(actual.getRewards().get(0)).isEqualTo(new Reward(rewardName));
    }

    @DisplayName("Players 수와 갯수가 같지 않으면 예외를 반환한다.")
    @Test
    void validate() {
        assertThatExceptionOfType(RewardsCountException.class)
                .isThrownBy(() -> new Rewards(rewards, 3))
                .withMessage(RewardsCountException.MESSAGE);
    }
}
