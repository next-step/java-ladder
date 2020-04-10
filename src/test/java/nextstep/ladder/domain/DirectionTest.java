package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    @DisplayName("왼쪽으로 이동가능한 Direction")
    @Test
    void nextDirection() {
        boolean left = true;
        boolean right = false;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("오른쪽으로 이동가능한 Direction")
    @Test
    void rightDirection() {
        boolean left = false;
        boolean right = true;
        Direction direction = Direction.of(left, right);
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("양쪽으로 이동가능한 경우 throws Exception")
    @Test
    void invalidDirection() {
        boolean left = true;
        boolean right = true;
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(left, right));
    }

    @DisplayName("현재 위치에서 오른쪽 Direction 생성")
    @Test
    void irection() {
        boolean left = true;
        boolean right = false;
        Direction direction = Direction.of(left, right).right();
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("현재 위치에서 왼쪽 Direction 생성")
    @Test
    void irection() {
        boolean left = true;
        boolean right = false;
        Direction direction = Direction.of(left, right).left();
        assertThat(direction.isLeft()).isTrue();
    }
}
