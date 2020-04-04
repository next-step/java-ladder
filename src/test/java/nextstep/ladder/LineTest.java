package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    @DisplayName("가로 라인이 겹치는 경우(내 왼쪽에 있는 Point와 내가 모두 hasLine이 true 이면 안된다.) Exception을 반환한다.")
    void assertPointHasLine() {
        List<Point> points = new ArrayList<>();
        Point point1 = new Point(0, true);
        Point point2 = new Point(1, true);

        points.add(point1);
        points.add(point2);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(points);
        }).withMessage(Line.POINT_HAS_LINE_ERROR);
    }
}
