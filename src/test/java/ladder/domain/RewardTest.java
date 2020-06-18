package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Reward 클래스 테스트")
public class RewardTest {

    @DisplayName("Reward 객체를 생성할 수 있다.")
    @Test
    void create() {
        String result = "꽝";
        Reward rewardTest = new Reward(result);

        assertThat(rewardTest).isEqualTo(new Reward(result));
    }
}
