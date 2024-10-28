package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Line;
import nextstep.ladder.v2.model.Point;
import nextstep.ladder.v2.model.PointGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("line class 생성")
    void createLineTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        //when
        Line line = new Line(countOfPlayers, pointGenerator);

        //then
        //       0    1     2
        // false true false false
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        List<Point> points = line.getPoints();
        Assertions.assertThat(points).hasSameElementsAs(expectedPoints);
    }

    @Test
    @DisplayName("line move - RIGHT")
    void lineMoveRightTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);

        //when
        int nextPosition = line.move(0);

        //then
        //       0    1     2
        // false true false false
        Assertions.assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("line move - LEFT")
    void lineMoveLeftTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);

        //when
        int nextPosition = line.move(1);

        //then
        //       0    1     2
        // false true false false
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        Assertions.assertThat(line.getPoints()).hasSameElementsAs(expectedPoints);

        Assertions.assertThat(nextPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("line move - DOWN")
    void lineMoveDownTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);

        //when
        int nextPosition = line.move(2);

        //then
        //       0    1     2
        // false true false false
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        Assertions.assertThat(line.getPoints()).hasSameElementsAs(expectedPoints);

        Assertions.assertThat(nextPosition).isEqualTo(2);
    }
}
