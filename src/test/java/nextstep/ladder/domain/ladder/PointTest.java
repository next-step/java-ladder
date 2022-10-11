package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("하나의 점은 위치와 사용 가능 여부 상태를 가진다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void point(boolean input) {
        assertThat(new Point(1, input)).isEqualTo(new Point(1, input));
    }

    @DisplayName("위치가 1 미만인 경우 예외가 발생한다.")
    @Test
    void pointException() {
        assertThatThrownBy(() -> new Point(0, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용 가능 상태를 정의할 수 있다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void pointStrategy(boolean input) {
        assertThat(Point.of(1, () -> input)).isEqualTo(new Point(1, input));
    }
}
