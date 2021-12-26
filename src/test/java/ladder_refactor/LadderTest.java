package ladder_refactor;

import ladder_refactor.domain.Ladder;
import ladder_refactor.domain.LadderLine;
import ladder_refactor.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    public void createLadder() {
        int sizeOfHeight = 5;
        int sizeOfPerson = 3;
        Ladder ladder = Ladder.init(sizeOfHeight, sizeOfPerson);
        List<LadderLine> lines = ladder.getLines();
        List<Point> points = lines.get(0).getPoints();

        Assertions.assertThat(lines.size()).isEqualTo(sizeOfHeight);
        Assertions.assertThat(points.size()).isEqualTo(sizeOfPerson);
    }

    @Test
    @DisplayName("사다리 타기")
    public void moveLadder() {
        List<LadderLine> lines = new ArrayList<>();

        List<Point> points = new ArrayList<>();
        Point firstPoint = Point.first(TRUE);
        points.add(firstPoint);
        points.add(firstPoint.last());

        // 첫번째 라인 생성
        lines.add(LadderLine.init(points));

        points = new ArrayList<>();
        firstPoint = Point.first(FALSE);
        points.add(firstPoint);
        points.add(firstPoint.last());

        // 두번째 라인 생성
        lines.add(LadderLine.init(points));

        Ladder ladder = Ladder.init(lines);
        Assertions.assertThat(ladder.move(0)).isEqualTo(1);
    }
}
