package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    Position position;

    @BeforeEach
    void setUp() {
        position = Position.builder()
                .row(2)
                .column(2)
                .build();
    }

    @Test
    @DisplayName("현재 위치에서 왼쪽 Column으로 1칸 이동")
    void left_move() {
        assertThat(position.left())
                .isEqualTo(Position.builder()
                .row(2)
                .column(1)
                .build());
    }

    @Test
    @DisplayName("현재 위치에서 오른쪽 Column으로 1칸 이동")
    void right_move() {
        assertThat(position.right())
                .isEqualTo(Position.builder()
                .row(2)
                .column(3)
                .build());
    }

    @Test
    @DisplayName("현재 위치에서 아래 Row으로 1칸 이동")
    void down_move() {
        assertThat(position.down())
                .isEqualTo(Position.builder()
                        .row(3)
                        .column(2)
                        .build());
    }
}
