package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {
    @Test
    @DisplayName("LEFT 면 포지션이 감소, DOWN 이면 그대로, RIGHT 면 증가해야한다.")
    void move() {
        int index = 5;
        assertAll(
                () -> assertThat(new Point(index, Direction.LEFT).move())
                        .isEqualTo(4),
                () -> assertThat(new Point(index, Direction.DOWN).move())
                        .isEqualTo(5),
                () -> assertThat(new Point(index, Direction.RIGHT).move())
                        .isEqualTo(6)
        );
    }

    @Test
    @DisplayName("Point 의 값 dto 로 잘 포장되는지 확인")
    void exportPointDto() {
        int index = 1;
        assertAll(
                () -> assertThat(new Point(index, Direction.LEFT).exportPointDto().getIsLeft())
                        .isTrue(),
                () -> assertThat(new Point(index, Direction.DOWN).exportPointDto().getIsLeft())
                        .isFalse(),
                () -> assertThat(new Point(index, Direction.RIGHT).exportPointDto().getIsLeft())
                        .isFalse()
        );
    }
}
