package ladder.domain.ladder;

import ladder.domain.point.Direction;
import ladder.domain.point.Point;
import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

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
    void trace는_position을_사다리를_따라서_이동시킨다() {
        Position position = new Position(1);

        Position leftMovedPosition = LEFT_ROW.trace(position);
        Position notMovedPosition = UNCONNECTED_ROW.trace(position);
        Position rightMovedPosition = RIGHT_ROW.trace(position);

        assertAll(
                () -> assertEquals(new Position(0), leftMovedPosition),
                () -> assertEquals(new Position(1), notMovedPosition),
                () -> assertEquals(new Position(2), rightMovedPosition)
        );
    }
}
