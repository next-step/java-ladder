package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PointTest {

    @DisplayName("Point의 값이 이미 존재하면 캐시에서 꺼내온다")
    @Test
    void cacheTest() {
        Point point1 = Point.of(1);
        Point point2 = Point.of(1);

        assertThat(point1).isSameAs(point2);
    }

}