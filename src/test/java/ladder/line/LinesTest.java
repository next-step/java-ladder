package ladder.line;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidLinesException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("라인들 추가하기")
    void add_lines() {
        Lines lines = new Lines(4);

        assertDoesNotThrow(() -> lines.addLines(List.of(
                        new ManualLine(3, List.of(false, false, true)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, false, true))
                )
        ));
    }

    @Test
    @DisplayName("검증을 통과하지 못한 라인이 있으면 예외 발생.")
    void fail_to_add_lines_with_invalid_line() {
        assertAll(
                () -> assertThatSingleLineInvalidLinesException(
                        new ManualLine(3, List.of(false, true, true))),
                () -> assertThatSingleLineInvalidLinesException(
                        new ManualLine(3, List.of(true, false, true))),
                () -> assertThatSingleLineInvalidLinesException(
                        new ManualLine(3, List.of(false, false))),
                () -> assertThatExceptionOfType(InvalidLinesException.class)
                        .isThrownBy(() ->
                                (new Lines(3)).addLines(
                                        List.of(
                                                new ManualLine(3, List.of(false, false, true)),
                                                new ManualLine(3, List.of(false, false, true))
                                        )
                                ))
        );
    }

    @Test
    @DisplayName("사다리 높이가 1 미만이면 예외 발생.")
    void fail_to_init_lines_by_invalid_height() {
        assertThatExceptionOfType(InvalidHeightException.class)
                .isThrownBy(() -> new Lines(0));
    }

    private void assertThatSingleLineInvalidLinesException(Line line) {
        Lines lines = new Lines(1);
        assertThatExceptionOfType(InvalidLinesException.class)
                .isThrownBy(() -> lines.addLines(List.of(line)));
    }

}