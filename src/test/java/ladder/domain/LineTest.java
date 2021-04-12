package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        List<Point> points = line.getPoints();

        // then
        assertAll(
            () -> assertThat(points.get(0).getPoint()).isTrue(),
            () -> assertThat(points.get(1).getPoint()).isFalse(),
            () -> assertThat(points.get(2).getPoint()).isTrue(),
            () -> assertThat(points.get(3).getPoint()).isFalse(),
            () -> assertThat(points.get(3).getPoint()).isFalse()
        );
    }

    @Test
    @DisplayName("point가 false는 연속으로 생성 가능하다")
    void false_continuously_possible() {
        // given
        Line line = Line.of(5, () -> Boolean.FALSE);

        // when
        List<Point> points = line.getPoints();

        // then
        assertAll(
            () -> assertThat(points.get(0).getPoint()).isFalse(),
            () -> assertThat(points.get(1).getPoint()).isFalse(),
            () -> assertThat(points.get(2).getPoint()).isFalse(),
            () -> assertThat(points.get(3).getPoint()).isFalse(),
            () -> assertThat(points.get(3).getPoint()).isFalse()
        );
    }

    @Test
    @DisplayName("마지막 point는 false로 생성된다")
    void last_point_is_false() {
        // given
        Line line = Line.of(3, () -> Boolean.TRUE);

        // when
        List<Point> points = line.getPoints();

        // then
        assertAll(
                () -> assertThat(points.get(0).getPoint()).isTrue(),
                () -> assertThat(points.get(1).getPoint()).isFalse(),
                () -> assertThat(points.get(2).getPoint()).isFalse()
        );
    }

    @DisplayName("move시 point가 true일 경우 오른쪽(인덱스 1증가)으로 이동한다")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,1", "2,3", "3,3", "4,4"})
    void move(int index, int expectedIndex) {
        // given
        Line line = Line.of(5, () -> Boolean.TRUE);

        // when
        int movedIndex = line.move(index);

        // then
        assertThat(movedIndex).isEqualTo(expectedIndex);

    }
}