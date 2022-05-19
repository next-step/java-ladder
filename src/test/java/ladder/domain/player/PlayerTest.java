package ladder.domain.player;

import ladder.domain.point.Direction;
import ladder.domain.point.Point;
import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    public static final Name PLAYER_ONE_NAME = Name.valueOf("PONE");
    public static final Player PLAYER_ONE = new Player(PLAYER_ONE_NAME, new Position(0));
    public static final Player PLAYER_TWO = new Player("PTWO", 1);

    @Test
    void Player은_이름_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Player(null, Position.initialize())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Player은_위치_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Player(Name.valueOf("name"), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LEFT|0", "NONE|1", "RIGHT|2"}, delimiter = '|')
    void move는_direction으로_위치를_이동한다(Direction direction, int position) {
        Player player = new Player("name", 1);

        Player movedPlayer = player.move(direction);

        assertTrue(movedPlayer.isOnPoint(new Point(Direction.RIGHT, new Position(position))));
    }
}
