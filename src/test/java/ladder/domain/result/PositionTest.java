package ladder.domain.result;

import ladder.domain.enums.Direction;
import ladder.domain.ladder.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PositionTest {

    @Test
    public void 위치_생성() {
        Position position = Position.of(3);

        assertThat(position).isEqualTo(Position.of(3));
    }

    @Test
    public void 포지션_오른쪽_이동() {
        Position position = Position.of(0);
        position.goRight();

        assertThat(position).isEqualTo(Position.of(1));
    }

    @Test
    public void 포지션_왼쪽_이동() {
        Position position = Position.of(2);
        position.goLeft();

        assertThat(position).isEqualTo(Position.of(1));
    }

    @Test(expected = RuntimeException.class)
    public void 첫번째_포지션_왼쪽_이동시_에러() {
        Position position = Position.of(0);
        position.goLeft();

    }

    @Test
    public void 위치_확인() {
        Position position = Position.of(0);

        List<Boolean> points = new ArrayList<>();
        points.add(Boolean.FALSE);
        points.add(Boolean.TRUE);

        Line line = new Line(points);

        assertThat(position.getDirection(line)).isEqualTo(Direction.RIGHT);
    }
}
