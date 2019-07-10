package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    @DisplayName("첫번째 Direction 생성")
    void firstDirection() {
        assertThat(Direction.first(true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.first(false)).isEqualTo(Direction.PASS);
    }

    @Test
    @DisplayName("마지막 Direction 생성")
    void lastDirection() {
        assertThat(Direction.first(true).last()).isEqualTo(Direction.LEFT);
        assertThat(Direction.first(false).last()).isEqualTo(Direction.PASS);
    }

    @Test
    @DisplayName("다음 Direction 생성")
    void nextDirection() {
        assertThat(Direction.first(true).next()).isEqualTo(Direction.LEFT);
        assertThat(Direction.first(false)).isNotEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("Direction 오른쪽 이동")
    void rightMove() {
        Position position = Position.first();
        Direction direction = Direction.first(true);

        assertThat(direction.move(position).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Direction 왼쪽으로 이동")
    void leftMove() {
        Position position = new Position(2);
        Direction direction = Direction.first(true).next();

        assertThat(direction.move(position).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Direction 이동 없음")
    void pass() {
        Position position = Position.first();
        Direction direction = Direction.first(false);

        assertThat(direction.move(position).getPosition()).isEqualTo(0);
    }


}
