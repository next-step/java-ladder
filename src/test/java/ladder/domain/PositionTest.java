package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    Position position;

    @BeforeEach
    @DisplayName("Position 초기값 1로 셋팅 ")
    void setup() {
        position = Position.first().increase();
    }

    @Test
    @DisplayName("Position 증가")
    void increase() {
        assertThat(position.increase().getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Position 감소")
    void decrease() {
        assertThat(position.decrease().getPosition()).isEqualTo(0);
    }

}
