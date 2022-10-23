package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("왼쪽, 오른쪽 전부 갈수 있는 Point")
    void test1() {
        // given
        Point point = new Point(0, true, true);
        // when
        boolean moveLeft = point.hasLeftLine();
        boolean moveRight = point.hasRightLine();
        // then
        assertThat(moveLeft).isTrue();
        assertThat(moveRight).isTrue();
    }

}
