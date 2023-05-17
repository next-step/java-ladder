package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    void 다음_x좌표구하기_테스트() {
        Point point1 = new Point(false, false);
        Point point2 = new Point(true, false);
        Point point3 = new Point(false, true);

        assertThat(point1.nextX(1)).isEqualTo(1);
        assertThat(point2.nextX(1)).isEqualTo(0);
        assertThat(point3.nextX(1)).isEqualTo(2);


    }
}
