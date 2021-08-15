package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.strategy.LeftMove;
import step3.strategy.NoMove;
import step3.strategy.RightMove;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("이동 방향을 결정하는 기능 테스트")
    void getMoveDirectionTest() {
        Line line = new Line(() -> Arrays.asList(true, false));

        assertThat(new Position(0).getMoveDirection(line)).isInstanceOf(RightMove.class);

        assertThat(new Position(1).getMoveDirection(line)).isInstanceOf(LeftMove.class);

        assertThat(new Position(2).getMoveDirection(line)).isInstanceOf(NoMove.class);
    }

    @Test
    @DisplayName("이동하지 않는 테스트")
    void justTest() {
        Position position = new Position(0);

        assertThat(position.just().equals(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 테스트")
    void toLeftTest() {
        Position position = new Position(1);

        assertThat(position.toLeft().equals(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("오른쪽으로 이동하는 테스트")
    void toRightTest() {
        Position position = new Position(1);

        assertThat(position.toRight().equals(new Position(2))).isTrue();
    }
}
