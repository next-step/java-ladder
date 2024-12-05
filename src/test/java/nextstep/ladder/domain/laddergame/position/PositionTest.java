package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.line.point.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void create_성공() {
        Position position = new Position(0);

        Assertions.assertThat(position).isNotNull();
        Assertions.assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void create_실패() {
        Assertions.assertThatThrownBy(() -> {
            Position position = new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Position position = new Position(1);
        Point point = new Point(false, true);

        Position movedPosition = position.move(point);

        Assertions.assertThat(movedPosition.getPosition()).isEqualTo(2);
    }
}