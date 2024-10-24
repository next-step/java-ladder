package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 왼쪽으로 이동한다.
- 오른쪽으로 이동한다.
*/
public class PointTest {

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
