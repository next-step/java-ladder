package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    @Test
    @DisplayName("정상 생성 테스트")
    void create() {
        assertThat(new Rewards(4, "1,2,3,4"))
                .extracting("rewards")
                .asList()
                .containsExactly(new Reward("1"), new Reward("2"), new Reward("3"), new Reward("4"));
    }

    @Test
    @DisplayName("리워드가 빈 값일 경우 Exception 발생")
    void emptyReward() {
        assertThatThrownBy(() -> new Rewards(4, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상은 빈값일 수 없습니다.");
    }

    @Test
    @DisplayName("리워드가 참여자 인수와 맞지 않을경우 Exception 발생")
    void notEqualSize() {
        assertThatThrownBy(() -> new Rewards(4, "1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상은 인원수와 같아야합니다.");
    }
}
