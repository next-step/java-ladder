package nextstep.ladder.domain.value;

import nextstep.ladder.doamin.value.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("지점 정상 생성 검증")
    void create(boolean expected) {
        Point point = Point.from(expected);

        assertThat(point.isTrue()).isEqualTo(expected);
    }

    @Test
    @DisplayName("값에 null인 경우 예외 발생 검증")
    void create_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.from(null));
    }
}
