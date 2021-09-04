package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardTest {
    @DisplayName("잘못된 보상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"100000", " ", ""})
    public void wrongInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Reward(input));
    }
}
