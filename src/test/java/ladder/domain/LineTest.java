package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @Test
    @DisplayName("point가 true를 연속으로 생성되지않는다")
    void true_continuously_impossible() {
        // given
        Line line = Line.of(5, () -> Boolean.TRUE);

        // when
        List<Boolean> points = line.getPoints();

        // then
        assertAll(
            () -> assertThat(points.get(0)).isTrue(),
            () -> assertThat(points.get(1)).isFalse(),
            () -> assertThat(points.get(2)).isTrue(),
            () -> assertThat(points.get(3)).isFalse(),
            () -> assertThat(points.get(3)).isFalse()
        );
    }

    @Test
    @DisplayName("point가 false는 연속으로 생성 가능하다")
    void false_continuously_possible() {
        // given
        Line line = Line.of(5, () -> Boolean.FALSE);

        // when
        List<Boolean> points = line.getPoints();

        // then
        assertAll(
            () -> assertThat(points.get(0)).isFalse(),
            () -> assertThat(points.get(1)).isFalse(),
            () -> assertThat(points.get(2)).isFalse(),
            () -> assertThat(points.get(3)).isFalse(),
            () -> assertThat(points.get(3)).isFalse()
        );
    }

    @Test
    @DisplayName("마지막 point는 false로 생성된다")
    void last_point_is_false() {
        // given
        Line line = Line.of(3, () -> Boolean.TRUE);

        // when
        List<Boolean> points = line.getPoints();

        // then
        assertAll(
                () -> assertThat(points.get(0)).isTrue(),
                () -> assertThat(points.get(1)).isFalse(),
                () -> assertThat(points.get(2)).isFalse()
        );
    }
}