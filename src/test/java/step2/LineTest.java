package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;
import step2.domain.Person;
import step2.domain.Point;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("Line 클래스 생성 테스트")
    void createLine() {
        Line line = new Line();
        assertThat(line).isEqualTo(new Line());
    }

    @Test
    @DisplayName("같은 라인에서는 연속으로 줄이 만들어 질 수 없다")
    void sameLineNotCreatedTest() {
        List<Point> points = Arrays.asList(new Point(true), new Point(true), new Point(false));

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
