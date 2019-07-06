package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Line(minimum))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
