package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {

    @Test
    @DisplayName("바로 옆에 있는 Point 들만 연결 가능하다")
    public void connectTest1() {
        Point p1 = Point.in(1);
        Point p2 = Point.in(3);
        assertThatIllegalArgumentException().isThrownBy(() -> p1.connect(p2));
    }

    @Test
    @DisplayName("연결이 되어 있지 않은 점들끼리만 연결 가능하다")
    public void connectTest2() {
        Point p1 = Point.in(1);
        Point p2 = Point.in(2);
        Point p3 = Point.in(3);

        p1.connect(p2);

        assertThatIllegalArgumentException().isThrownBy(() -> p3.connect(p2)).withMessage("양 옆으로 연결이 되어 있지 않은 점들끼리만 연결 가능하다");
    }
}
