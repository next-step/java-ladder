package ladder.view;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.Point;

class LineDisplayTest {
    @DisplayName("point 를 symbol 로 변환하여 line 을 만들어 리턴한다.")
    @ParameterizedTest
    @MethodSource("showSet")
    void show(List<Point> points, String expected) {
        assertThat(new LineDisplay(1).show(points)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> showSet() {
        return Stream.of(
                Arguments.arguments(List.of(VERTICAL_LINE, HORIZON, HORIZON, VERTICAL_LINE), "|--|"),
                Arguments.arguments(List.of(BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE), " |-|"),
                Arguments.arguments(List.of(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK), "|-| ")
        );
    }
}
