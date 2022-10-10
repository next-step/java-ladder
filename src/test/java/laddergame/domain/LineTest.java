package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값이면 IllegalArgumentException")
    void null_or_empty_exception(List<Boolean> line) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(line));
    }

    @Test
    @DisplayName("첫번째 값이 true면 IllegalArgumentException")
    void first_value_when_true_then_exception() {
        //given
        List<Boolean> values = Arrays.asList(true, false, true);
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(values));
    }

    @Test
    @DisplayName("값이 연속으로 true가 나오면 IllegalArgumentException")
    void true_연속_exception() {
        //given
        List<Boolean> values = Arrays.asList(false, true, true);
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(values));
    }

}
