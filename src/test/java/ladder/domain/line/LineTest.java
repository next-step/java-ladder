package ladder.domain.line;

import static ladder.domain.Position.LINE_START_POSITION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.domain.Position;
import ladder.domain.direction.Direction;
import ladder.domain.point.Point;
import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 좌표추가_테스트() {
        Line line = new Line();
        line.addPoint(new Point(LINE_START_POSITION, Direction.RIGHT));
        line.addPoint(new Point(new Position(1), Direction.LEFT));
    }

    @Test
    void 가로라인이_겹치는거_확인_테스트() {
        Line line = new Line();
        line.addPoint(new Point(LINE_START_POSITION, Direction.RIGHT));
        assertThrows(LadderGameException.class, () -> line.addPoint(new Point(new Position(1), Direction.RIGHT)));
    }

    @Test
    void getNextLinePositionTest() {
        Line line = new Line();
        Position secondPosition = new Position(1);
        line.addPoint(new Point(LINE_START_POSITION, Direction.RIGHT));
        line.addPoint(new Point(secondPosition, Direction.LEFT));
        assertThat(line.getNextLinePosition(LINE_START_POSITION)).isEqualTo(secondPosition);
    }
}