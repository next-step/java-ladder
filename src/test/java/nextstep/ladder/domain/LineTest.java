package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @ParameterizedTest
    @DisplayName("List<Point>로 Line을 생성한다")
    @MethodSource
    void createLine(List<Point> points) {
        assertThat(Line.from(points)).isInstanceOf(Line.class);
    }

    static Stream<Arguments> createLine() {
        return Stream.of(
                Arguments.of(
                    Arrays.asList(Point.from(Boolean.TRUE), Point.from(Boolean.FALSE), Point.from(Boolean.TRUE))
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Line의 생성 인자 값이 null이거나 1 이하인 경우 예외가 발생한다")
    @NullAndEmptySource
    void createException(List<Point> points) {
        assertThatThrownBy(() -> Line.from(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line에 연속된 사다리 행이 존재할때 예외가 발생한다")
    void continuousRowException() {
        List<Point> points = Arrays.asList(Point.from(Boolean.TRUE), Point.from(Boolean.TRUE), Point.from(Boolean.TRUE));

        assertThatThrownBy(() -> Line.from(points)).isInstanceOf(ContinuousRowException.class);
    }
}
