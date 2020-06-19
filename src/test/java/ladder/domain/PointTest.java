package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        assertThatCode(() -> Point.movable()).doesNotThrowAnyException();
        assertThat(Point.movable() == Point.movable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("이 전 값이 true이면 false를 반환한다")
    void checkLineOverlap(boolean random) {
        Point point = Point.movable();
        point = point.checkOverlap(random);

        assertThat(point.isPoint()).isFalse();
    }
    @Test
    @DisplayName("이 전 값이 false인 경우 인자 값에 따라 결과가 반환 된다.")
    void checkLineOverlap() {
        Point point = Point.stop();

        assertThat(point.checkOverlap(true).isPoint()).isTrue();
        assertThat(point.checkOverlap(false).isPoint()).isFalse();
    }

}
