package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("한 라인은 점의 갯수로 생성된다.")
    void new_WithNumberOfParticipants_Created() {
        final int numberOfPoints = 5;
        final Line line = Line.generateRandom(numberOfPoints);
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("한 라인은 2개 미만의 점으로 생성할 수 없다")
    void new_WithInsufficientPoints_ExceptionThrown() {
        final int minimum = Line.MINIMUM_NUMBER_OF_POINTS;
        assertThatThrownBy(() -> Line.generateRandom(minimum - 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line에서 얻은 Points는 수정할 수 없다.")
    void getPoints_Modify_ExceptionThrown() {
        final int numberOfPoints = 5;
        final Line line = Line.generateRandom(numberOfPoints);
        final List<Point> points = line.getPoints();

        assertThatThrownBy(() -> points.add(Point.firstOf(new RandomConnector())))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("오른쪽으로 연결된 Line의 Point는 다음 Point의 위치를 반환한다.")
    void move_ToRight_moved() {
        final List<Point> points = new ArrayList<>();
        final Point first = Point.firstOf(() -> true);
        final Point end = first.endOf();
        points.add(first);
        points.add(end);

        final Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("아래로 연결된 Line의 Point는 현재 Point의 위치를 반환한다.")
    void move_ToDown_moved() {
        final List<Point> points = new ArrayList<>();
        final Point first = Point.firstOf(() -> false);
        final Point end = first.endOf();
        points.add(first);
        points.add(end);

        final Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽으로 연결된 Line의 Point는 앞선 Point의 위치를 반환한다.")
    void move_ToLeft_moved() {
        final List<Point> points = new ArrayList<>();
        final Point first = Point.firstOf(() -> true);
        final Point end = first.endOf();
        points.add(first);
        points.add(end);

        final Line line = new Line(points);

        assertThat(line.move(1)).isEqualTo(0);
    }
}
