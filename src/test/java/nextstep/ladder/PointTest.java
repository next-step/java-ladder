package nextstep.ladder;

import static nextstep.ladder.domain.ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.domain.ladder.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("왼쪽이 이미 연결되어 있다면 그 다음엔 연결하지 않는다.")
    void LEFT_ALREADY_CONNECTED_THEN_NOT_CONNECTED() {
        Point point = Point.of(true, false);
        assertThat(Point.first(() -> true).next(() -> true)).isEqualTo(point);
    }

    @Test
    @DisplayName("왼쪽 오른쪽 모두 연결되어 있을 수 없다.")
    void VALID_POINT() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Point.of(true, true));
    }

    @Test
    @DisplayName("왼쪽과 연결되어 있으면 왼쪽으로 이동한다.")
    void MOVE_LEFT() {
        Point point = Point.first(() -> true).next(() -> false);
        assertThat(point.move()).isEqualTo(LEFT);
    }

    @Test
    @DisplayName("오른쪽과 연결되어 있으면 오른쪽으로 이동한다.")
    void MOVE_RIGHT() {
        Point point = Point.first(() -> false).next(() -> true);
        assertThat(point.move()).isEqualTo(RIGHT);
    }

    @Test
    @DisplayName("연결되어 있지 않으면 그대로 지나간다.")
    void MOVE_PASS() {
        Point point = Point.first(() -> false);
        assertThat(point.move()).isEqualTo(PASS);
    }

}
