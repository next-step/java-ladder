package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {
    @Test
    @DisplayName("보상수와 인원수가 맞지않으면 예외발생한다.")
    void insertPlayerCountRewardNotEqualsException() {

        assertThatThrownBy(
                () -> Reward.of("5000,3000,꽝,꽝", 5)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("인원수와 보상을  넣으면 인원수만큼 보상 아님 꽝이 출력된다.")
    void insertPlayerAndUsersPrintReward() {
        Reward rewards = Reward.of("5000,3000,꽝,꽝,꽝", 5);

        rewards.getRewardList().forEach(reward -> System.out.print(reward + ONE_BLANK_SPACE));

        assertThat(rewards.getRewardList()).extracting(reward -> reward).contains("5000", "3000", "꽝");

    }

}
