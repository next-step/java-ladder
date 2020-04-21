package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("아래 방향으로 연결되어 있지 않은 점들은 다른 점들과 연결이 존재한다고 본다.")
    public void existConnectTest() {
        Point p1 = Point.in(1);
        Point p2 = Point.in(2);
        Point p3 = Point.in(3);

        p1.connect(p2);

        assertThat(p1.existConnect()).isTrue();
        assertThat(p2.existConnect()).isTrue();
        assertThat(p3.existConnect()).isFalse();
    }
}
