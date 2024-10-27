package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Ladder;
import nextstep.ladder.v2.model.Line;
import nextstep.ladder.v2.model.Point;
import nextstep.ladder.v2.model.PointGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {
    @Test
    @DisplayName("ladder class 생성")
    void createLadderTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);

        //when
        Ladder ladder = new Ladder(List.of(line));

        //then
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        Assertions.assertThat(ladder.getLines()).hasSize(1);
        List<Point> points = ladder.getLines().get(0).getPoints();
        Assertions.assertThat(points).hasSameElementsAs(expectedPoints);
    }

    @Test
    @DisplayName("ladder creatLadder")
    void createLadderWithStaticMethodTest() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);
        int height = 1;

        //when
        Ladder ladder = Ladder.of(countOfPlayers).createLadder(height, pointGenerator);

        //then
        List<Point> expectedPoints = List.of(new Point(false, true), new Point(true, false), new Point(false, false));
        Assertions.assertThat(ladder.getLines()).hasSize(1);
        List<Point> points = ladder.getLines().get(0).getPoints();
        Assertions.assertThat(points).hasSameElementsAs(expectedPoints);
    }

    @Test
    @DisplayName("ladder move - right direction")
    void ladderMoveTest_RightDirection() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);
        Ladder ladder = new Ladder(List.of(line));

        //when
        int position = ladder.move(0);

        //then
        //       0    1     2
        // false true false false
        Assertions.assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("ladder move - left direction")
    void ladderMoveTest_LeftDirection() {
        //given
        int countOfPlayers = 3;
        PointGenerator pointGenerator = new MockPointGenerator();
        Line line = new Line(countOfPlayers, pointGenerator);
        Ladder ladder = new Ladder(List.of(line));

        //when
        int position = ladder.move(1);

        //then
        //       0    1     2
        // false true false false
        Assertions.assertThat(position).isEqualTo(0);
    }
}
