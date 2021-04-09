package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.LineNumber;
import ladder.domain.Point;

public class PointTest {

    @Test
    void 생성_값_테스트() {
        assertThat(Point.of(0, true).toBoolean()).isEqualTo(true);
        assertThat(Point.of(0, false).toBoolean()).isEqualTo(false);
    }

    @Test
    void 생성_라인번호_테스트() {
        assertThat(Point.of(1, true).getLineNumber()).isEqualTo(LineNumber.valueOf(1));
        assertThat(Point.of(2, false).getLineNumber()).isEqualTo(LineNumber.valueOf(2));
    }

    @Test
    void 이전_현재_연결_테스트() {
        // given
        Point point = Point.of(0, false);
        Point prevPoint = Point.of(1, true);
        // when & then
        assertThat(point.prevCompare(prevPoint)).isEqualTo(point);
    }

    @Test
    void 이전_현재_연결_테스트_2() {
        // given
        Point point = Point.of(0, true);
        Point prevPoint = Point.of(1, true);
        // when & then
        assertThat(point.prevCompare(prevPoint)).isEqualTo(prevPoint);
    }

    @Test
    void 다음_현재_연결_테스트() {
        // given
        Point point = Point.of(0, false);
        Point nextPoint = Point.of(1, true);
        // when & then
        assertThat(point.nextCompare(nextPoint)).isEqualTo(nextPoint);
    }

    @Test
    void 다음_현재_연결_테스트_2() {
        // given
        Point point = Point.of(0, false);
        Point nextPoint = Point.of(1, false);
        // when & then
        assertThat(point.nextCompare(nextPoint)).isEqualTo(point);
    }

    @Test
    void 이전_현재_다음_연결_테스트() {
        // given
        Point prevPoint = Point.of(0, false);
        Point point = Point.of(1, true);
        Point nextPoint = Point.of(2, false);
        // when & then
        assertThat(point.compare(prevPoint, nextPoint)).isEqualTo(prevPoint);
    }

    @Test
    void 이전_현재_다음_연결_테스트_2() {
        // given
        Point prevPoint = Point.of(0, true);
        Point point = Point.of(1, false);
        Point nextPoint = Point.of(2, true);
        // when & then
        assertThat(point.compare(prevPoint, nextPoint)).isEqualTo(nextPoint);
    }

}
