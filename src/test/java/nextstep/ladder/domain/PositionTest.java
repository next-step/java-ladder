package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("정적 팩토리 메소드")
    void from() {
        Position actual = Position.from(1);
        Position expected = new Position(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toInt() {
        Position position = Position.from(1);

        assertThat(position.toInt()).isEqualTo(1);
    }

    @Test
    @DisplayName("포지션은 오른쪽으로 이동한다")
    void moveRight() {
        Position position = Position.from(1);
        Position moved = position.move(new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE), () -> Boolean.FALSE));

        assertThat(moved).isEqualTo(Position.from(2));
    }

    @Test
    @DisplayName("포지션은 왼쪽으로 이동한다")
    void moveLeft() {
        Position position = Position.from(1);
        Position moved = position.move(new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), () -> Boolean.FALSE));

        assertThat(moved).isEqualTo(Position.from(0));
    }
}