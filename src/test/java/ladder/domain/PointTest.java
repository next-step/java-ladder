package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        assertThatCode(() -> Point.of(true)).doesNotThrowAnyException();
        assertThat(Point.of(true) == Point.of(true)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("이 전 값이 true이면 false를 반환한다")
    void checkLineOverlap(boolean random) {
        Point point = Point.of(true);
        point = point.checkOverlap(random);

        assertThat(point.isPoint()).isFalse();
    }

}
