package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @ParameterizedTest(name = "true, false, true 의 라인이 있는경우 {0}번째 포시션의 움직인 후 위치는 {1} 이다.")
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    void move(int index, int expected) {
        Line line = new Line(List.of(new Point(true), new Point(false), new Point(true)));
        Position position = new Position(index);

        assertThat(position.move(line)).isEqualTo(new Position(expected));
    }
}