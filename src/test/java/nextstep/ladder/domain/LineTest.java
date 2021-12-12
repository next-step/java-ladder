package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("create Line test")
    void createLine() {
        List<Boolean> booleanList = new RandomBooleanListGenerator(5).generate();
        Line line = LineGenerator.generate(booleanList);

        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("Line의 생성 인자 값이 null이거나 1 이하인 경우 예외가 발생한다")
    void createException() {
        assertThatThrownBy(() -> Line.from(Collections.emptyList())).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Line을 이동한 이후 index를 리턴")
    @MethodSource
    void move(Line line, int startIndex, int expectedIndex) {
        assertThat(line.move(startIndex)).isEqualTo(expectedIndex);
    }

    static Stream<Arguments> move() {
        /*
        0      1      2      3      4      5
        |------|      |------|      |      |
         */
        Line line = Line.from(
                Arrays.asList(
                        Column.head(Boolean.TRUE),
                        Column.body(Boolean.TRUE, Boolean.FALSE),
                        Column.body(Boolean.FALSE, Boolean.TRUE),
                        Column.body(Boolean.TRUE, Boolean.FALSE),
                        Column.body(Boolean.FALSE, Boolean.FALSE),
                        Column.tail(Boolean.FALSE)
                )
        );
        return Stream.of(
                Arguments.of(line, 0, 1),
                Arguments.of(line, 1, 0),
                Arguments.of(line, 2, 3),
                Arguments.of(line, 3, 2),
                Arguments.of(line, 4, 4),
                Arguments.of(line, 5, 5)
        );
    }
}
