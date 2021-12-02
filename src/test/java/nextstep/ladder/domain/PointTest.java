package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest
    @DisplayName("Point를 생성한다")
    @ValueSource(booleans = {true, false})
    void create(boolean value) {
        Point point = Point.from(value);

        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("true를 가진 Point 에서 next Point를 생성 하면 false를 가진 Point가 생성된다")
    void next() {
        Point point = Point.from(Boolean.TRUE);
        Point next = point.next(Boolean.TRUE);

        assertThat(next.isTrue()).isFalse();
    }
}