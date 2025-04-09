package laddergameRDD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergameRDD.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {
    @DisplayName("사다리 한 점의 양 옆에 가로 선이 있을 경우 에러")
    @Test
    void create_point_error() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Point(true, true)
        );
    }

    @DisplayName("사다리 한 점에서 오른쪽 이동")
    @Test
    void move_right() {
        assertThat(new Point(false, true).move()).isEqualTo(RIGHT);
    }

    @DisplayName("사다리 한 점에서 왼쪽 이동")
    @Test
    void move_left() {
        assertThat(new Point(true, false).move()).isEqualTo(LEFT);
    }

    @DisplayName("사다리 한 점에서 아래 이동")
    @Test
    void move_down() {
        assertThat(new Point(false, false).move()).isEqualTo(DOWN);
    }
}
