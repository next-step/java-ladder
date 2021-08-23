package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;
import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    @DisplayName("인원수를 넣으면 인원수만큼 보상 아님 꽝이 출력된다.")
    void insertPlayerCountResultReward() {
        Reward rewards = Reward.of(5);

        rewards.getRewardList().forEach(reward -> System.out.print(reward + ONE_BLANK_SPACE));

        assertThat(rewards.getRewardList()).extracting(reward -> reward).contains("5000", "3000", "꽝");

    }


    @Test
    @DisplayName("player목록 셋팅 해당위치플레이어가 최종적으로 도착하고 출력하는 테스트 ")
    void insertPlayerSettingTest() {
        Reward rewards = Reward.of(5);
        rewards.setPlayerList(1);
        assertThat(rewards.getRewardResult().get(0)).isEqualTo(1);

    }

}
