package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Line line = Line.of(2, () -> true);

        assertThat(line).isNotNull();
    }

    @DisplayName("사다리 한줄이 의도적으로 생성되었는지 테스트")
    @Test
    void createLineAllTrue() {
        Point pointTrue = new Point(true);
        Point pointFalse = new Point(false);
        List<Point> excepted = Arrays.asList(pointFalse, pointTrue, pointFalse, pointTrue);

        Line line = Line.of(4, () -> true);
        List<Point> actual = line.getLine();

        assertThat(actual.size()).isEqualTo(excepted.size());

        for (int i =0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(excepted.get(i));
        }
    }

    @DisplayName("좌우가 이어진 사다리의 가로 한줄에서의 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:1", "5:6", "6:5"}, delimiter = ':')
    void moveLine(int currentPoint, int result) {
        // 사다리 모양
        // |-| |-| |-|
        Line line = Line.of(7, () -> true);

        assertThat(line.move(currentPoint)).isEqualTo(result);
    }

    @DisplayName("이어지지 않은 사다리의 가로 한줄에서의 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5", "6:6"}, delimiter = ':')
    void moveNotLine(int currentPoint, int result) {
        // 사다리 모양
        // | | | | | |
        Line line = Line.of(7, () -> false);

        assertThat(line.move(currentPoint)).isEqualTo(result);
    }
}
