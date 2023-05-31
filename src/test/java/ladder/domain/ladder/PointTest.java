package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    private LineStrategy lineStrategy;
    private LineStrategy lineStrategyTrue;
    private LineStrategy lineStrategyFalse;

    @BeforeEach
    void setUp() {
        lineStrategy = new RandomLineStrategy();
        lineStrategyTrue = () -> true;
        lineStrategyFalse = () -> false;
    }

    @Test
    @DisplayName("처음의 왼쪽값은 false 이다.")
    void leftOfFirstPoint_Value_False() {
        assertThat(Point.first(lineStrategy)).left().isFalse();
    }

    @Test
    @DisplayName("마지막의 오른쪽의 값은 false 이다.")
    void rightOfLastPoint_Value_False() {
        assertThat(Point.first(lineStrategy).last(lineStrategy)).right().isFalse();
    }

    @Test
    @DisplayName("왼쪽이 true이고, 오른쪽이 false이면 왼쪽으로 이동한다.")
    void move_LeftTrue_rightFalse_MoveLeft() {
        Point point = Point.first(lineStrategyTrue).next(lineStrategyFalse);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("왼쪽이 false이고, 오른쪽이 true이면 오른쪽 이동한다.")
    void move_LeftFalse_rightTrue_MoveRight() {
        Point point = Point.first(lineStrategyFalse).next(lineStrategyFalse);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 둘 다 false이면 밑으로 이동한다.")
    void move_LeftFalse_RightFalse_MoveSouth() {
        Point point = Point.first(lineStrategyFalse).next(lineStrategyFalse);
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }

}
