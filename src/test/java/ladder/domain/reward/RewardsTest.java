package ladder.domain.reward;

import ladder.domain.data.PlayerData;
import ladder.domain.data.RewardData;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RewardsTest {

    @DisplayName("인스턴스 생성")
    @Test
    void create() {
        Players players = Players.create(PlayerData.make(2));
        List<Reward> rewards = RewardData.make(2);

        assertThat(Rewards.create(rewards, players)).isInstanceOf(Rewards.class);
    }

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        Players players = Players.create(PlayerData.make(2));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rewards.create(null, players));
    }

    @DisplayName("리워드와 플레이어의 수가 일치하지 않으면 예외 발생")
    @Test
    void createNotMatchCount() {
        Players players = Players.create(PlayerData.make(2));
        List<Reward> rewards = RewardData.make(3);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rewards.create(rewards, players));
    }
}
