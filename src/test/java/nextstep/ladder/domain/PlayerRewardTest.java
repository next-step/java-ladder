package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerRewardTest {

    private Player player = Player.newInstance("a", 0);
    private Reward reward = Reward.newInstance("1000");
    private PlayerReward playerReward = new PlayerReward();

    @BeforeEach
    void setUp() {
        this.playerReward.put(this.player, this.reward);
    }

    @DisplayName("참여자 보상을 추가할 수 있다.")
    @Test
    void canPut() {
        Player player = Player.newInstance("b", 1);
        Reward reward = Reward.newInstance("2000");
        this.playerReward.put(player, reward);

        assertThat(this.playerReward.count()).isEqualTo(2);
    }

    @DisplayName("해당 참여자의 보상을 얻을 수 있다.")
    @Test
    void canGet() {
        assertThat(this.playerReward.get(this.player)).isEqualTo(this.reward);
    }

    @DisplayName("참여자들의 수를 얻을 수 있다.")
    @Test
    void canCount() {
        assertThat(this.playerReward.count()).isOne();
    }

    @DisplayName("Map 으로 변환할 수 있다.")
    @Test
    void canToMap() {
        assertThat(this.playerReward.toMap()).isInstanceOf(Map.class);
    }
}
