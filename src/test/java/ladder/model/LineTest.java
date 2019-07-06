package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("한 라인은 점의 갯수로 생성된다.")
    void new_WithNumberOfParticipants_Created() {
        final int numberOfPoints = 5;
        final Line line = new Line(numberOfPoints);
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("한 라인은 2개 미만의 점으로 생성할 수 없다")
    void new_WithInsufficientPoints_ExceptionThrown() {
        final int minimum = Line.MINIMUM_NUMBER_OF_POINTS;
        assertThatThrownBy(() -> new Line(minimum - 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line에서 얻은 Points는 수정할 수 없다.")
    void getPoints_Modify_ExceptionThrown() {
        final int numberOfPoints = 5;
        final Line line = new Line(numberOfPoints);
        final List<Point> points = line.getPoints();

        assertThatThrownBy(() -> points.add(Point.firstOfRandom()))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }
}
