package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {
    @Test
    @DisplayName("first point의 right가 true이면 다음(아래) 인덱스는 1, false 이면 다음(아래) 인덱스가 0이다.")
    void firstPointTest() {
        assertAll(
                () ->  assertThat(Point.first(true).move()).isEqualTo(1),
                () ->  assertThat(Point.first(false).move()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("left, right Direction이 모두 없는 경우 다음(아래) Point 인덱스는 현재 Point 인덱스와 같다")
    void stayTest() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("left Direction인 경우 다음(아래) Point 인덱스는 현재 Point 인덱스 보다 1 작다.")
    void leftTest() {
        Point point = Point.first(true).next();
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("right Direction인 경우 다음(아래) Point 인덱스는 현재 Point 인덱스 보다 1 크다.")
    void rightTest() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }
}
