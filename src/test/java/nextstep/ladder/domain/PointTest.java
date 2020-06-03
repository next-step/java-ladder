package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    private Point point = Point.newInstance(true);

    @DisplayName("포인트를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void canCreatePoint(boolean hasPoint) {
        assertThat(Point.newInstance(hasPoint)).isInstanceOf(Point.class);
    }

    @DisplayName("생성 전략이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreatePointIfStrategyIsNull() {
        assertThatThrownBy(() -> Point.first(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> this.point.next(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 번째 포인트 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void canCreateFirstPoint(boolean hasPoint) {
        assertThat(Point.first(() -> hasPoint)).isInstanceOf(Point.class);
    }

    @DisplayName("다음 포인트를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void canCreateNextPoint(boolean hasPoint) {
        assertThat(this.point.next(() -> hasPoint)).isInstanceOf(Point.class);
    }

    @DisplayName("가로 라인은 겹칠 수 없다.")
    @Test
    void canNotOverlapPoint() {
        Point prevPoint = Point.newInstance(true);
        assertThatThrownBy(() -> this.point.validate(prevPoint)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포인트 존재여부를 얻을 수 있다.")
    @Test
    void canGetHasPoint() {
        assertThat(this.point.hasPoint()).isTrue();
    }
}
