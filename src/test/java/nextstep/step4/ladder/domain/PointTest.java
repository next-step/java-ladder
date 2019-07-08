package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 03:09
 */
public class PointTest {
    @DisplayName("Point 생성 예외 - current가 0번째 (왼쪽노드가 없을때)")
    @Test
    void createException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(0, new Direction(true, false));
        }).withMessageContaining("왼쪽노드가 유효하지 않습니다. (0번째 Link의 왼쪽노드는 flase만 허용합니다.)");
    }

    @DisplayName("Point 생성 예외 - current와 left의 상태가 둘다 ture일 경우")
    @Test
    void createTrueException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(1, new Direction(true, true));
        }).withMessageContaining("현재 Link와 Left Link가 모두 true면 안됩니다.");
    }

    @DisplayName("첫 번째 Point 생성")
    @Test
    void createFirst() {
        assertThat(Point.first(() -> true).matchIndex(0)).isTrue();
    }

    @DisplayName("다음 Point 생성")
    @Test
    void createNext() {
        Point point = Point.first(() -> true);
        assertThat(point.next(() -> false).matchIndex(1)).isTrue();
    }

    @DisplayName("마지막 Point 생성")
    @Test
    void createLast() {
        Point point = Point.first(() -> true);
        assertThat(Point.last(point).matchIndex(1)).isTrue();
    }

    @DisplayName("이동을 확인한다 - true")
    @Test
    void moveTrue() {
        Point point = new Point(0, new Direction(false, true));
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("이동을 확인한다 - false")
    @Test
    void moveFalse() {
        Point point = new Point(0, new Direction(false, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("이동을 확인한다 - 본인은 false, 왼쪽 Link는 true")
    @Test
    void moveFalseAndBeforeLinkTrue() {
        Point point = new Point(1, new Direction(true, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("현재 Link의 상태를 확인한다.")
    @Test
    void checkStatus() {
        assertThat(Point.first(() -> true).status()).isTrue();
    }
}
