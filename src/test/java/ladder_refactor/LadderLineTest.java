package ladder_refactor;

import ladder_refactor.domain.LadderLine;
import ladder_refactor.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class LadderLineTest {

    @Test
    @DisplayName("사다리 초기화 테스트")
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        Assertions.assertThat(ladderLine.getPoints().size()).isEqualTo(sizeOfPerson);
    }

    @Test
    @DisplayName("사다리 이동 테스트")
    public void move() {
        List<Point> points = new ArrayList<>();
        Point firstPoint = Point.first(TRUE);
        points.add(firstPoint);
        points.add(firstPoint.last());
        LadderLine line = LadderLine.init(points);
        Assertions.assertThat(line.move(0)).isEqualTo(1);
    }
}
