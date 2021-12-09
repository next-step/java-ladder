package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("방향 객체 생성")
    void create() {
        Direction direction = new Direction(true, false);
        assertThat(direction).isEqualTo(new Direction(true, false));
    }

    @Test
    @DisplayName("false/true")
    void setDirection() {
        Direction direction = Direction.createRandomDirection(() -> true);
        assertThat(direction.isRight()).isTrue();
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("false/false")
    void setDirection1() {
        Direction direction = Direction.createRandomDirection(() -> false);
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isFalse();
    }

}