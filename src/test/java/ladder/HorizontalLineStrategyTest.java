package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalLineStrategyTest {

    @Test
    @DisplayName("현재 라인이 양옆 라인과 겹치지 않는다.")
    void test1() {
        // given
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false, true));
        points.add(new Point(1, true, false));
        HorizontalLineStrategy horizontalLineStrategy = (left, right, point) -> false;
        // when
        boolean line = horizontalLineStrategy.areLinesNotOverlapped(0, 1, points);
        // then
        assertThat(line).isTrue();
    }

    @Test
    @DisplayName("현재 라인이 양옆 라인과 겹친다.")
    void test2() {
        // given
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, true, true));
        points.add(new Point(1, true, false));
        HorizontalLineStrategy horizontalLineStrategy = (left, right, point) -> false;
        // when
        boolean line = horizontalLineStrategy.areLinesNotOverlapped(0, 1, points);
        // then
        assertThat(line).isFalse();
    }

}