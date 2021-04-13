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
    @DisplayName("pointStrategy가 true 고정일때 Line 객체를 생성하면 point가 true를 연속으로 생성 안 한다")
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
    @DisplayName("pointStrategy가 false 고정일때 Line 객체를 생성하면 모든 point가 false로 생성한다")
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
    @DisplayName("Line 객체를 생성하면 마지막 Point는 false로 생성한다")
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

    @DisplayName("|----|    |----|    | 일때 move하면 point에 맞게 index가 이동한다")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    void move(int index, int expectedIndex) {
        // given
        Line line = Line.of(5, () -> Boolean.TRUE);

        // when
        int movedIndex = line.move(index);

        // then
        assertThat(movedIndex).isEqualTo(expectedIndex);

    }
}