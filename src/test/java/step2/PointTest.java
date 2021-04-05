package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("Point 클래스 생성")
    void createPoint() {
        Point point = new Point(true);
        assertThat(point).isEqualTo(new Point(true));
    }

    @Test
    @DisplayName("특정 위치에서 오른쪽으로 움직인다.")
    void moveRightTest() {
        Point point = new Point(false);
        assertThat(point.move(false)).isEqualTo(point.currentPoint());
    }

    @Test
    @DisplayName("특정 위치에서 오른쪽으로 움직인다.")
    void moveLeftTest() {
        Point point = new Point(true);
        assertThat(point.move(true)).isEqualTo(point.currentPoint());
    }
}
