package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CrossTest {

    @DisplayName("Cross 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    void right() {
        // given
        int position = 1;
        int executed = 2;
        Point right = Point.first(true);

        // when
        Cross cross = new Cross(position, right);

        // then
        assertThat(cross.move()).isEqualTo(executed);
    }

    @DisplayName("Cross 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    void left() {
        // given
        int position = 1;
        int executed = 0;
        Point left = Point.first(true).next(false);

        // when
        Cross cross = new Cross(position, left);

        // then
        assertThat(cross.move()).isEqualTo(executed);
    }


    @DisplayName("Cross 인스턴스가 그대로 아래로 이동하는지 테스트")
    @Test
    void pass() {
        // given
        int position = 1;
        int executed = 1;
        Point pass = Point.first(false);

        // when
        Cross cross = new Cross(position, pass);

        // then
        assertThat(cross.move()).isEqualTo(executed);
    }
}