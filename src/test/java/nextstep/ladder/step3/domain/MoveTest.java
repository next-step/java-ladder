package nextstep.ladder.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step3.domain.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveTest {

    @ParameterizedTest
    @CsvSource(value = "true,false")
    @DisplayName("left 가 True 일 경우")
    void leftTrue(boolean left, boolean present) {
        assertThat(Move.of(left, present).move()).isEqualTo(-1);
    }

    @ParameterizedTest
    @CsvSource(value = "false,true")
    @DisplayName("present 가 True 일 경우")
    void presentTrue(boolean left, boolean present) {
        assertThat(Move.of(left, present).move()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = "false,false")
    @DisplayName("둘다 FALSE 일 경우")
    void allFalse(boolean left, boolean present) {
        assertThat(Move.of(left, present).move()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = "true,true")
    @DisplayName("둘다 TRUE 일 시 예외처리")
    void allTrue(boolean left, boolean present) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Move.of(left, present));
    }

}
