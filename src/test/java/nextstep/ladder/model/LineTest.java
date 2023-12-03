package nextstep.ladder.model;

import nextstep.ladder.model.strategy.FixedLineStrategy;
import nextstep.ladder.model.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    @DisplayName("두 Line의 동일한 index는 둘 다 Point.LEFT일 수 없다.")
    void test1() {
        //given
        Line lineA = new Line(List.of(Point.LEFT, Point.LEFT, Point.LEFT, Point.NO_POINT, Point.NO_POINT)
                , new RandomLineStrategy());
        Line lineB = lineA.generateLine();
        //then
        assertThat(lineA.point(0)).isNotEqualTo(lineB.point(0));
        assertThat(lineA.point(1)).isNotEqualTo(lineB.point(1));
    }

    @Test
    @DisplayName("두 사다리 사이에 모든 라인이 그어져 있는 사다리를 생성할 수 있다.")
    void test2() {
        //given
        Line lineA = new Line(List.of(Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new FixedLineStrategy(true));
        Line lineB = lineA.generateLine();
        //then
        assertThat(lineB.points()).containsExactly(Point.LEFT, Point.LEFT, Point.LEFT, Point.LEFT, Point.LEFT);
    }

    @Test
    @DisplayName("두 사다리 사이에 모든 라인이 그어져 있지 않은 사다리를 생성할 수 있다.")
    void test3() {
        //given
        Line lineA = new Line(List.of(Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT)
                , new FixedLineStrategy(false));
        Line lineB = lineA.generateLine();
        //then
        assertThat(lineB.points()).containsExactly(Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT, Point.NO_POINT);
    }
}