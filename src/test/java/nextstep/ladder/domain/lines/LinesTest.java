package nextstep.ladder.domain.lines;

import static nextstep.ladder.domain.Line.HORIZONTAL_LINE_OVERLAPPING_EXCEPTION;
import static nextstep.ladder.domain.Line.LINE_LENGTH_DIFFERENCE_EXCEPTION;
import static nextstep.ladder.domain.lines.Lines.NONE_NORM_LINE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("사다리의 수평선이 겹치면 예외를 던진다.")
    void horizontal_lines_overlapping_exception() {
        // when // then
        assertThatThrownBy(() -> new Lines(createOverlappingLines()))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(HORIZONTAL_LINE_OVERLAPPING_EXCEPTION);
    }

    private List<Line> createOverlappingLines() {
        Line line1 = Line.createLine2WithPointStatus(List.of(true, false, true));
        Line line = Line.createLine2WithPointStatus(List.of(false, true, false));
        Line line3 = Line.createLine2WithPointStatus(List.of(false, true, true));
        return List.of(line1, line, line3);
    }

    @Test
    @DisplayName("사다리의 줄 들의 길이가 다르면 예외들 던진다.")
    void not_same_line_length_exception() {
        // when // then
        assertThatThrownBy(() -> new Lines(createDifferentLengthLines()))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(LINE_LENGTH_DIFFERENCE_EXCEPTION);
    }

    private List<Line> createDifferentLengthLines() {
        Line line1 = Line.createLine2WithPointStatus(List.of(true, false, true));
        Line line = Line.createLine2WithPointStatus(List.of(false, true, false));
        Line line3 = Line.createLine2WithPointStatus(List.of(false, false, false, true));
        return List.of(line1, line, line3);
    }

    @Test
    @DisplayName("길이가 모두 동일한 라인인지 비교할 때, 기준 라인이 존재하지 않으면 예외를 던진다.")
    void none_norm_line_exception() {
        // when // then
        assertThatThrownBy(() -> new Lines(Arrays.asList(null, Line.createLine2WithPointStatus(List.of(true, false)))))
                .isExactlyInstanceOf(NullPointerException.class)
                .hasMessage(NONE_NORM_LINE_EXCEPTION);
    }
}
