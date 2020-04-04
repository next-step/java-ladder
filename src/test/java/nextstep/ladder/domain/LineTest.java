package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    RightDirection rightDirection;

    @BeforeEach
    void setUp() {
        rightDirection = () -> true;
    }

    @DisplayName("입력한 수 만큼의 길이의 가로 라인이 만들어진다.")
    @Test
    void lineSize() {
        int size = 3;
        Line line = new Line(size, rightDirection);
        assertThat(line.size()).isEqualTo(size);
    }

    @DisplayName("마지막 포인트는 무조건 선이 없다.")
    @Test
    void lastIsFalse() {
        int size = 3;
        Line line = new Line(size, rightDirection);
        assertThat(line.last()).isEqualTo(Point.of(false));
    }

    @DisplayName("연속으로 포인트에 선이 있을 수 없다.")
    @Test
    void notConsecutivePoint() {
        Line line = new Line(3, rightDirection);

        Point before = Point.of(false);
        for (Point point : line) {
            assertThat(before.hasRightDirection() && point.hasRightDirection())
                    .isFalse();

            before = point;
        }
    }
}
