package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.point.Direction;
import ladder.domain.point.Point;
import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RowTest {
    static final Row LEFT_ROW = new Row(List.of(
            new Point(Direction.RIGHT, Position.initialize()),
            new Point(Direction.LEFT, new Position(1)),
            new Point(Direction.NONE, new Position(2))
    ));
    static final Row UNCONNECTED_ROW = new Row(List.of(
            new Point(Direction.NONE, Position.initialize()),
            new Point(Direction.NONE, new Position(1)),
            new Point(Direction.NONE, new Position(2))
    ));
    static final Row RIGHT_ROW = new Row(List.of(
            new Point(Direction.NONE, Position.initialize()),
            new Point(Direction.RIGHT, new Position(1)),
            new Point(Direction.LEFT, new Position(2))
    ));

    @Test
    void Row는_points_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Row(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidth은_ladderWidth로_Row를_생성한다() {
        int ladderWidth = 5;

        Row row = Row.generateByWidth(ladderWidth);

        assertAll(
                () -> assertEquals(ladderWidth, row.width()),
                () -> assertInstanceOf(Row.class, row)
        );
    }

    @Test
    void trace는_player를_사다리를_따라서_이동시킨다() {
        Player player = new Player("name", 1);

        Player leftMovedPlayer = LEFT_ROW.trace(player);
        Player notMovedPlayer = UNCONNECTED_ROW.trace(player);
        Player rightMovedPlayer = RIGHT_ROW.trace(player);

        assertAll(
                () -> assertTrue(leftMovedPlayer.isOnPoint(new Point(Direction.RIGHT, new Position(0)))),
                () -> assertTrue(notMovedPlayer.isOnPoint(new Point(Direction.RIGHT, new Position(1)))),
                () -> assertTrue(rightMovedPlayer.isOnPoint(new Point(Direction.RIGHT, new Position(2))))
        );
    }
}
