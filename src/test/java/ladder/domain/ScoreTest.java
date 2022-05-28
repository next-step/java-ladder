package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreTest {
    @Test
    @DisplayName("점수를 생성한다.")
    void Score_점수_생성() {
        assertThat(new Score("꽝")).isNotNull().isInstanceOf(Score.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("점수를 생성시 스코어 값이 null 또는 빈 값일 경우 예외가 발생한다.")
    void Score_점수_생성_예외(String scoreValue) {
        assertThatThrownBy(() -> new Score(scoreValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"wu2eee, aaaaaa, abcdef"})
    @DisplayName("전달받은 참가자 이름 길이가 5를 초과하면 예외가 발생한다.")
    void Score_점수_최대_이름_예외(String scoreValue) {
        assertThatThrownBy(() -> new Score(scoreValue)).isInstanceOf(IllegalArgumentException.class);
    }
}