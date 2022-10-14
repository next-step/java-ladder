package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("선은 점이 하나 이상으로 구성되어야 하므로 점이 비어있는 경우 예외가 발생한다.")
    @Test
    void lineSizeException() {
        List<Point> points = List.of();
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두번 연속 나란히 연결되는 점이 포함되어 있는 경우 예외가 발생한다.")
    @Test
    void linePointsException() {
        Point first = Point.first(() -> true);
        Point nextPoint = Point.of(1, false, true);

        List<Point> points = List.of(first, nextPoint);

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("원하는 수 만큼의 점을 가진 선을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5})
    void creatLine(int input) {
        Line line = Line.create(input, () -> true);

        assertThat(line.points()).hasSize(input);
    }
}
