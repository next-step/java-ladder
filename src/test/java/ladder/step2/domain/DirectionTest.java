package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    public static final Direction PASS = new Direction(false, false);
    public static final Direction LEFT = new Direction(true, false);
    public static final Direction RIGHT = new Direction(false, true);
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        assertThat(RIGHT.isRight()).isTrue();
        assertThat(RIGHT.isLeft()).isFalse();
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        assertThat(LEFT.isLeft()).isTrue();
        assertThat(LEFT.isRight()).isFalse();
    }
}
