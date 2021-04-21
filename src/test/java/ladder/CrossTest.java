package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CrossTest {

    @DisplayName("Cross 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    void right() {
        Point right = Point.first(true);
        Cross cross = new Cross(1, right);
        assertThat(cross.move()).isEqualTo(2);
    }

    @DisplayName("Cross 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    void left() {
        Point left = Point.first(true).next(false);
        Cross cross = new Cross(1, left);
        assertThat(cross.move()).isEqualTo(0);
    }
}