package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    @DisplayName("결과를 생성한다")
    void create() {
        Result result = new Result(new PlayerName("pobi"), new RewardName("꽝"));
        Result equalExpected = new Result(new PlayerName("pobi"), new RewardName("꽝"));
        Result notEqualExpected = new Result(new PlayerName("꽝"), new RewardName("pobi"));

        assertThat(result).isEqualTo(equalExpected);
        assertThat(result).isNotEqualTo(notEqualExpected);
    }

    @Test
    @DisplayName("보상이름을 출력한다")
    void rewardName() {
        Result result = new Result(new PlayerName("pobi"), new RewardName("꽝"));
        RewardName actual = result.rewardName();
        RewardName expected = new RewardName("꽝");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어의 결과인지 출력한다")
    void isPlayerResult() {
        Result result = new Result(new PlayerName("pobi"), new RewardName("꽝"));
        boolean actual = result.isPlayerResult(new PlayerName("pobi"));
        boolean actualFalse = result.isPlayerResult(new PlayerName("crong"));

        assertThat(actual).isTrue();
        assertThat(actualFalse).isFalse();
    }
}
