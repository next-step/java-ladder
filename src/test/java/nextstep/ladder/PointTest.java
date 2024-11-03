package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("사다리 점 왼쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_왼쪽_연결_테스트() {
        Point point = new Point(false, false);

        point.connectLeft();

        assertThat(point.isLeft()).isTrue();
    }

    @Test
    @DisplayName("사다리 점 오른쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_오른쪽_연결_테스트() {
        Point point = new Point(false, false);

        point.connectRight();

        assertThat(point.isRight()).isTrue();
    }


    @Test
    @DisplayName("사다리 점 왼쪽이 이미 연결 되어있을 때 오른쪽으로 연결 시도 시 예외 발생")
    void 왼쪽_이미_연결_시_오른쪽_연결시도_시_예외_발생() {
        Point point = new Point(true, false);

        Assertions.assertThatThrownBy(
                () -> point.connectRight()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽으로 연결할 수 없습니다");
    }

    @Test
    @DisplayName("사다리 점 오른쪽이 이미 연결 되어있을 때 왼쪽으로 연결 시도 시 예외 발생")
    void 오른쪽_이미_연결_시_왼쪽_연결시도_시_예외_발생() {
        Point point = new Point(false, true);

        Assertions.assertThatThrownBy(
                () -> point.connectLeft()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("왼쪽으로 연결할 수 없습니다");
    }


}
