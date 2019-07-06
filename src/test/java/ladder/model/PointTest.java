package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("Point는 왼쪽, 오른쪽 연결 정보로 생성한다.")
    void new_WithConnectionInformation_Created() {
        final boolean left = false;
        final boolean right = true;
        final Point point = new Point(left, right);
        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("Point는 양방향 연결이면 예외를 발생한다.")
    void new_WithTwoWayConnection_ExceptionThrown() {
        final boolean left = true;
        final boolean right = true;
        assertThatThrownBy(() -> new Point(left, right))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
