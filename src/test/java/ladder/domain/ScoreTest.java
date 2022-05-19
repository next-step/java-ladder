package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreTest {
    @Test
    @DisplayName("점수를 생성한다.")
    void Score_점수_생성() {
        assertThat(new Score("꽝", 3)).isNotNull().isInstanceOf(Score.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 6})
    @DisplayName("전달받은 참가자 이름의 최대 길이가 1 ~ 5를 벗어나면 예외가 발생한다.")
    void Score_점수_최대_이름_예외(int maxNameLength) {
        assertThatThrownBy(() -> new Score("꽝", maxNameLength)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100, 10",
            "꽝꽝꽝, 10",
            "불가능함, 100"
    })
    @DisplayName("입력 받은 점수의 길이가 참가자 이름의 최대길이보다 클 경우 예외가 발생한다.")
    void Score_점수_길이와_최대_이름_길이_예외(String scoreValue, String name) {
        assertThatThrownBy(() -> new Score(scoreValue, name.length())).isInstanceOf(IllegalArgumentException.class);
    }
}