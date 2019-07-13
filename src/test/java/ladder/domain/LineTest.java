package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 플레이어_수_만큼_포인트를_랜덤으로_생성한다() {
        int numberOfPlayers = 5;
        Line line = Line.from(numberOfPlayers);

        assertThat(line.getPoints().size()).isEqualTo(numberOfPlayers);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0"})
    void 플레이어의_위치를_변경한다(int currentPosition, int expectedPosition) {
        //given
        Position initialPosition = Position.from(currentPosition);
        Point firstPoint = Point.makeFirstPoint(Direction.RIGHT);
        Point middlePoint = Point.of(Position.from(1), Direction.LEFT);
        Point lastPoint = Point.of(Position.from(2), Direction.PASS);
        Line line = new Line(Arrays.asList(firstPoint, middlePoint, lastPoint));

        //when
        Position movedPosition = line.travel(initialPosition);

        //then
        assertThat(movedPosition.getPosition()).isEqualTo(expectedPosition);
    }
}
