package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    public static final Position ONE = new Position(1);
    
    @Test
    @DisplayName("패스")
    void pass() {
        assertThat(ONE.pass()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        assertThat(ONE.moveLeft()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        assertThat(ONE.moveRight()).isEqualTo(2);
    }
}