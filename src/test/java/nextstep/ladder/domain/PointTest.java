package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest
    @DisplayName(value = "첫번째 좌표 생성")
    @CsvSource(value = {"true:RIGHT", "false:DOWN"}, delimiter = ':')
    void first(boolean input, String direction) {
        Point first = Point.first(input);
        assertThat(new Point(Direction.valueOf(direction), 0))
                .isEqualTo(first);
    }

    @ParameterizedTest
    @DisplayName(value = "다음 좌표 생성")
    @CsvSource(value = {"true:false:LEFT", "false:true:RIGHT", "false:false:DOWN"}, delimiter = ':')
    void next(boolean input, boolean nextInput, String direction) {
        Point point = Point.first(input);
        Point next = point.next(nextInput);
        assertThat(new Point(Direction.valueOf(direction), 1))
                .isEqualTo(next);
    }

    @ParameterizedTest
    @DisplayName(value = "마지막 좌표 생성")
    @CsvSource(value = {"true:LEFT", "false:DOWN"}, delimiter = ':')
    void last(boolean input, String direction) {
        Point point = Point.first(input);
        Point last = Point.last(point);
        assertThat(new Point(Direction.valueOf(direction), 1))
                .isEqualTo(last);
    }
}