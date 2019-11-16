package nextstep.ladder.domain;

import nextstep.ladder.view.OutputView;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    private List<Point> pointList;

    @BeforeEach
    void setUp() {
        List<Line> lineList = new ArrayList<>();
        pointList = Lists.newArrayList(Point.firstIndex(), Point.firstIndex(), Point.firstIndex());
        lineList.add(new Line(pointList));
        ladder = new Ladder(lineList, pointList.size());
    }

    @Test
    @DisplayName("ladder index 와 height를 전달해 Direction을 얻어 오는지 확인 한다.")
    void ladderDirection() {
        assertThat(ladder.ladderDirection(0, 1)).isIn(Direction.RIGHT, Direction.BOTTOM);
    }

    @Test
    @DisplayName("시작 index를 넣으면 종료 index가 정상적으로 나오는지 확인 한다.")
    void result() {
        int height = 3;
        int startIndex = 0;
        int expectedIndex = 1;
        List<Line> exampleLines = Arrays.asList(
                new Line(Arrays.asList(new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT))),
                new Line(Arrays.asList(new Point(1, Direction.LEFT), new Point(1, Direction.LEFT), new Point(1, Direction.LEFT)))
        );
        Ladder ladder = new Ladder(new Lines(exampleLines), height);

        assertThat(ladder.result(startIndex)).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("시작 index를 넣으면 종료 index가 정상적으로 나오는지 확인 한다.")
    void result3() {
        int height = 3;
        int startIndex = 1;
        int expectedIndex = 1;
        List<Line> exampleLines = Arrays.asList(
                new Line(Arrays.asList(new Point(0, Direction.BOTTOM), new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT))),
                new Line(Arrays.asList(new Point(1, Direction.BOTTOM), new Point(1, Direction.LEFT), new Point(1, Direction.LEFT))),
                new Line(Arrays.asList(new Point(2, Direction.RIGHT), new Point(2, Direction.RIGHT), new Point(2, Direction.BOTTOM))),
                new Line(Arrays.asList(new Point(3, Direction.LEFT), new Point(3, Direction.LEFT), new Point(3, Direction.BOTTOM)))
        );
        Ladder ladder = new Ladder(new Lines(exampleLines), height);

        Peoples peoples = Peoples.of("pobi,honux,crong,jk");
        Gifts gifts = Gifts.of("pobi,honux,crong,jk");
        String resultName = "all";
        OutputView.printLadder(ladder, peoples, gifts);
        OutputView.printResult(resultName, ladder, peoples, gifts);
        assertThat(ladder.result(startIndex)).isEqualTo(expectedIndex);
    }
}
