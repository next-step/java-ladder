package JavaLadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

    @Test
    @DisplayName("포인트생성테스트")
    public void pointTest() {
        Point point = new Point(0);
        assertThat(point.getPoint()).isEqualTo(0);
    }

    @Test
    @DisplayName("포인트이동테스트")
    public void pointMoveTest() {
        Point point = new Point(0);
        point.moveRight();
        assertThat(point.getPoint()).isEqualTo(1);
        point.moveLeft();
        assertThat(point.getPoint()).isEqualTo(0);
    }
}
