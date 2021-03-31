package ladder.entity.moveStrategy;

import ladder.entity.Direction;
import ladder.entity.ladderMap.Link;
import ladder.entity.ladderMap.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyJudgeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void returnsMoveLeft(int index) {
        Point point = new Point(index);
        Link link = new Link(point, new MoveRight());
        MoveStrategy moveStrategy = MoveStrategyJudge.strategy(link);
        assertThat(moveStrategy.move()).isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void returnsStillOrRight(int index) {
        Point point = new Point(index);
        Link link = new Link(point, new MoveStill());
        MoveStrategy moveStrategy = MoveStrategyJudge.strategy(link);
        Direction direction = moveStrategy.move();
        assertThat(direction.equals(Direction.RIGHT) || direction.equals(Direction.STILL)).isTrue();
    }
}
