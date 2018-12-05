package ladder.model;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void 위치_생성() {
        Position position0 = Position.of(0);
        Position position2 = Position.of(2);

        assertThat(position0).isEqualTo(Position.of(0));
        assertThat(position2).isEqualTo(Position.of(2));
    }

    @Test
    public void 위치값_증가() {
        Position position = Position.of(0);

        position.increment();
        assertThat(position).isEqualTo(Position.of(1));

        position.increment();
        assertThat(position).isEqualTo(Position.of(2));

    }

    @Test
    public void 위치값_감소() {
        Position position = Position.of(2);

        position.decrement();
        assertThat(position).isEqualTo(Position.of(1));

        position.decrement();
        assertThat(position).isEqualTo(Position.of(0));
    }

    @Test(expected = RuntimeException.class)
    public void 위치값_감소_마이너스() {
        Position position = Position.of(0);
        position.decrement();
    }

    @Test
    public void 위치_확인() {
        Position position = Position.of(0);

        List<Boolean> points = new ArrayList<>();
        points.add(Boolean.FALSE);
        points.add(Boolean.TRUE);

        Line line = Line.of(points);

        Direction direction = position.getDirection(line);

        assertThat(direction).isEqualTo(Direction.RIGHT);


    }
}