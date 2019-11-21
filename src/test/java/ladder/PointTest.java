package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 포인트_생성() {
        Point point = new Point(Boolean.TRUE);

        assertThat(point).isEqualTo(new Point(Boolean.TRUE));
    }

    @Test
    void 랜덤_포인트_생성() {
        Point point = Point.ofRandom();

        assertThat(point.getPoint()).isIn(Boolean.TRUE, Boolean.FALSE);
    }

    @Test
    void 포인트_TRUE_확인() {
        Point point = new Point(Boolean.TRUE);

        assertThat(point.checkTrue()).isTrue();
    }

    @Test
    void 포인트_이동_시작점() {
        Point point = new Point(Boolean.TRUE);
        assertThat(point.moveStartIndex()).isEqualTo(1);
    }

    @Test
    void 포인트_이동_끝() {
        Point point = new Point(Boolean.TRUE);
        assertThat(point.moveEndIndex()).isEqualTo(-1);
    }
}
