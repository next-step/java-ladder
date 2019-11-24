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
    void next() {
        Point point = Point.first();
        assertThat(point).isNotEqualTo(point.next(true,5));
    }

    @Test
    void point_to_text_test() {
        Point point = Point.first();
        point = point.next(Boolean.FALSE, 5);
        assertThat(point.pointToBridge()).isEqualTo(LadderBridge.EMPTY);
    }
}
