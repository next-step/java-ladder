package ladder.view;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.Line;
import ladder.domain.Point;

class LineDisplayerTest {
    @DisplayName("point 를 symbol 로 변환하여 line 을 만들어 리턴한다.")
    @ParameterizedTest
    @MethodSource("showSet")
    void show(List<Point> points, String expected) {
        assertThat(new LineDisplayer(List.of(createLine(points)), 1).makeSingleLine(points)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> showSet() {
        return Stream.of(
                Arguments.arguments(List.of(VERTICAL_LINE, HORIZON, HORIZON, VERTICAL_LINE), "|--|"),
                Arguments.arguments(List.of(BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE), " |-|"),
                Arguments.arguments(List.of(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK), "|-| ")
        );
    }
    
    private static Line createLine(List<Point> points) {
        return new Line(3) {
            @Override
            public int nextLineIndex(int userIndex) {
                return 0;
            }

            @Override
            public List<Point> getPoints() {
                return points;
            }

            @Override
            protected Point choiceBeforeLast(Point before) {
                return VERTICAL_LINE;
            }
        };
    }
}
