package ladder.domain.line;

import static ladder.domain.line.BarHelper.getBars;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import ladder.domain.exception.InvalidHeightException;
import ladder.domain.exception.MismatchHeightLinesException;
import ladder.domain.exception.NullLinesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("라인들 추가하기")
    void add_lines() {
        Lines lines = new Lines(4);

        assertDoesNotThrow(() -> lines.addLines(List.of(
                        new Line(3, getBars(List.of(false, false, true))),
                        new Line(3, getBars(List.of(false, true, false))),
                        new Line(3, getBars(List.of(false, true, false))),
                        new Line(3, getBars(List.of(false, false, true)))
                )
        ));
    }

    @Test
    @DisplayName("검증을 통과하지 못한 라인이 있으면 예외 발생.")
    void fail_to_add_lines_with_invalid_line() {
        assertAll(
                this::assertThatNullLineInvalidLinesException,
                () -> assertThatMismatchHeightLinesException(
                        3,
                        List.of(
                                new Line(3, getBars(List.of(false, false, true))),
                                new Line(3, getBars(List.of(false, false, true)))
                        ))
        );
    }

    @Test
    @DisplayName("사다리 높이가 1 미만이면 예외 발생.")
    void fail_to_init_lines_by_invalid_height() {
        assertThatExceptionOfType(InvalidHeightException.class)
                .isThrownBy(() -> new Lines(0));
    }

    private void assertThatNullLineInvalidLinesException() {
        Lines lines = new Lines(1);
        assertThatExceptionOfType(NullLinesException.class)
                .isThrownBy(() -> lines.addLines(null));
    }

    private void assertThatMismatchHeightLinesException(int height, List<Line> lineData) {
        Lines lines = new Lines(height);
        assertThatExceptionOfType(MismatchHeightLinesException.class)
                .isThrownBy(() -> lines.addLines(lineData));
    }

}
