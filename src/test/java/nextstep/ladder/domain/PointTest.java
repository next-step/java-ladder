package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:41
 */
public class PointTest {

    @Test
    void 객체_생성() {
        Point point = Point.first();
        assertThat(point).isEqualTo(Point.first());
    }

    @Test
    void next() {
        Point point = Point.first();
        assertThat(point).isNotEqualTo(point.next());
    }

    @Test
    void point_to_text() {
        Point point = Point.first();
        assertThat(point.pointToBridge()).isEqualTo(LadderBridge.EMPTY);
    }
}
