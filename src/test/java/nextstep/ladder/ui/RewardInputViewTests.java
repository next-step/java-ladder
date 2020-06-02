package nextstep.ladder.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardInputViewTests {
    @DisplayName("문자열을 입력받아서 Rewards 일급 컬렉션을 속성으로 갖는 객체를 만들 수 있다.")
    @Test
    void createTest() {
        String rewardsValue = "꽝, 5000, 꽝, 5000";

        assertThat(new RewardInputView(rewardsValue)).isNotNull();
    }

    @DisplayName("입력된 문자열이 비어있거나 null일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = { " ", "" })
    void createValidationTest(String invalidValue) {
        assertThatThrownBy(() -> new RewardInputView(invalidValue)).isInstanceOf(IllegalArgumentException.class);
    }
}
