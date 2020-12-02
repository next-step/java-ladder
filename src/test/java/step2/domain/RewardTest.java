package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTest {

    private Reward reward;
    @BeforeEach
    void setUp(){
         reward = Reward.of("a");
    }

    @Test
    @DisplayName("상품이 잘 생성되는지 확인")
    void create() {
        assertThat(reward).isEqualTo(Reward.of("a"));
    }

    @Test
    @DisplayName("플레이어 이름 확인")
    void validName() {
        assertThat(reward.getRewardName()).isEqualTo("a");
    }
}