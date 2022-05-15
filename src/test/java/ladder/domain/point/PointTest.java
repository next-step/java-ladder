package ladder.domain.point;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {
    @Test
    void Point는_direction_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Point(null, Position.initialize())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Point는_position_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Point(Direction.RIGHT, null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move는_player를_이동시킨다() {
        Point point = new Point(Direction.RIGHT, Position.initialize());
        Player player = new Player("name", 0);

        Player movedPlayer = point.move(player);

        assertTrue(movedPlayer.isOnPoint(new Point(Direction.RIGHT, new Position(1))));
    }

    @Test
    void first는_초기_position으로_point를_생성한다() {
        Point point = Point.first();

        assertTrue(point.isSamePosition(Position.initialize()));
    }

    @Test
    void next는_증가된_position으로_point를_생성한다() {
        Point point = Point.first().next();

        assertTrue(point.isSamePosition(new Position(1)));
    }

    @Test
    void nextLast는_증가된_position으로_point를_생성한다() {
        Point point = Point.first().nextLast();

        assertTrue(point.isSamePosition(new Position(1)));
    }

}
