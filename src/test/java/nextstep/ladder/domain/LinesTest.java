package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @ParameterizedTest
    @DisplayName("List<Line>으로 Lines를 생성한다")
    @MethodSource
    void createLines(List<Line> lines) {
        assertThat(Lines.from(lines)).isInstanceOf(Lines.class);
    }

    static Stream<Arguments> createLines() {
        List<Point> points = Arrays.asList(Point.from(Boolean.TRUE), Point.from(Boolean.FALSE), Point.from(Boolean.TRUE));
        List<Line> lines = Collections.singletonList(Line.from(points));

        return Stream.of(
                Arguments.of(
                        lines
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Lines 의 생성인자가 1이하라면 예외가 발생한다")
    @NullAndEmptySource
    void createException(List<Line> lines) {
        assertThatThrownBy(() -> Lines.from(lines)).isInstanceOf(IllegalArgumentException.class);
    }
}