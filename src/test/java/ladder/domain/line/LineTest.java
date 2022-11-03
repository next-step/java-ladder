package ladder.domain.line;

import static ladder.domain.line.BarHelper.getBars;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.exception.InvalidCountOfPersonException;
import ladder.domain.exception.InvalidLineException;
import ladder.domain.exception.MismatchPersonBarsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("사다리 바 그리기 룰 검증")
    void init_line() {
        assertAll(
                () -> assertDoesNotThrow(
                        () -> new Line(4, getBars(List.of(false, true, false, true)))),
                () -> assertThatExceptionOfType(InvalidLineException.class)
                        .isThrownBy(() -> new Line(4, getBars(List.of(false, true, true, false)))),
                () -> assertThatExceptionOfType(InvalidLineException.class)
                        .isThrownBy(() -> new Line(4, getBars(List.of(true, false, true, false)))),
                () -> assertThatExceptionOfType(MismatchPersonBarsException.class)
                        .isThrownBy(() -> new Line(4, getBars(List.of(false, true, false))))
        );
    }

    @Test
    @DisplayName("사람수가 1 미만이면 예외 발생")
    void fail_to_init_line_by_invalid_count_of_person() {
        assertThatExceptionOfType(InvalidCountOfPersonException.class)
                .isThrownBy(() -> new Line(0, new ArrayList<>()));
    }

}
