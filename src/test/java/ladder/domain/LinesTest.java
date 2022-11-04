package ladder.domain;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LinesTest {
    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results(List.of("result1", "result2", "result3", "result4"));
    }

    @DisplayName("사용자의 순서를 파라미터로 받아 결과를 리턴한다.")
    @ParameterizedTest
    @MethodSource("findResultBy")
    void findResultBy(List<Line> lines, int userOrder, String expected) {
        assertThat(new Lines(lines, results).findResultBy(userOrder)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> findResultBy() {
        return Stream.of(
                Arguments.arguments(lines1, 1, "result4"),
                Arguments.arguments(lines1, 2, "result2"), 
                Arguments.arguments(lines1, 3, "result1"), 
                Arguments.arguments(lines1, 4, "result3"),
                Arguments.arguments(lines2, 1, "result1"),
                Arguments.arguments(lines2, 2, "result2"),
                Arguments.arguments(lines2, 3, "result3"),
                Arguments.arguments(lines2, 4, "result4"),
                Arguments.arguments(lines3, 1, "result2"),
                Arguments.arguments(lines3, 2, "result1"),
                Arguments.arguments(lines3, 3, "result3"),
                Arguments.arguments(lines3, 4, "result4")
        );
    }
    
    private static final List<Line> lines1 = List.of(
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE),
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE)
    );

    private static final List<Line> lines2 = List.of(
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE)
    );

    private static final List<Line> lines3 = List.of(
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE),
            new BodyLine(VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE, HORIZON, VERTICAL_LINE),
            new EdgeLine(VERTICAL_LINE, HORIZON, VERTICAL_LINE, BLANK, VERTICAL_LINE, BLANK, VERTICAL_LINE)
    );
}
