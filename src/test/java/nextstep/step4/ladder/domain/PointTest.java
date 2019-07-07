package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 12:45
 */
public class PointTest {
    @DisplayName("현재 포지션의 상태(boolean)를 확인")
    @Test
    void pointStatus() {
        Point point = new Point(true, false);
        assertThat(point.current()).isTrue();
    }

    @DisplayName("현재 포지션의 왼쪽 상태(boolean)를 확인")
    @Test
    void pointLeftStatus() {
        Point point = new Point(true, false);
        assertThat(point.left()).isFalse();
    }
}
