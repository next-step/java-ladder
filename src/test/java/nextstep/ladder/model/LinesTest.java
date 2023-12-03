package nextstep.ladder.model;

import nextstep.ladder.model.strategy.line.RandomLineStrategyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @Test
    @DisplayName("모든 Line의 특정 인덱스 값을 올바르게 리턴한다.")
    void test1() {
        //given
        Line lineA = new Line(List.of(Point.NO_POINT, Point.LEFT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());
        Line lineB = new Line(List.of(Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());
        Line lineC = new Line(List.of(Point.NO_POINT, Point.LEFT, Point.LEFT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategyImpl());

        List<Line> lineList = new ArrayList<>();
        lineList.add(lineA);
        lineList.add(lineB);
        lineList.add(lineC);

        Lines lines = new Lines(lineList);
        //then
        assertThat(lines.horizonLineDrawAvailable(0))
                .containsExactly(false, false, false);
        assertThat(lines.horizonLineDrawAvailable(1))
                .containsExactly(true, false, true);
    }
}