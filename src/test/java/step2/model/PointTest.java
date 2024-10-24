package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 첫 사다리 좌우 여부를 생성한다.
- 다음 사다리 좌우 여부를 생성한다.
- 왼쪽으로 이동한다.
- 오른쪽으로 이동한다.
*/
public class PointTest {

    @DisplayName("첫 사다리 좌우 여부를 생성한다.")
    @Test
    void firstTest() {
        Point point = Point.first(true);
        assertThat(point).extracting("left", "right")
                .containsExactly(
                        false, true
                );
    }

    @DisplayName("다음 사다리 좌우 여부를 생성한다.")
    @Test
    void nextTest() {
        Point point = Point.first(true);
        Point nextPoint = point.next(false);
        assertThat(nextPoint).extracting("left", "right")
                .containsExactly(
                        true, false
                );
    }

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void moveLeftTest() {
        Point point = new Point(true, false);

        assertThat(point.move(1)).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void moveRightTest() {
        Point point = new Point(false, true);

        assertThat(point.move(1)).isEqualTo(2);
    }
}
