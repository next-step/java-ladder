package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("getLadderBarStatus 테스트")
    public void getLadderBarStatus() {
        // given
        Ladder ladder = new Ladder(new Players("a,b,c"), new Height(3));
        int expectedHeight = 3;
        int expectedWidth = 2;

        // when
        List<List<Boolean>> ladderBarStatus = ladder.getLadderBarStatus();
        int height = ladderBarStatus.size();
        int width = ladderBarStatus.get(0).size();

        // then
        assertThat(height).isEqualTo(expectedHeight);
        assertThat(width).isEqualTo(expectedWidth);
    }

    @Test
    @DisplayName("startMoving 테스트")
    public void startMoving() {
        // given
        // given
        Point point0 = new Point(0, Direction.RIGHT);
        Point point1 = new Point(1, Direction.LEFT);
        Point point2 = new Point(2, Direction.NONE);
        List<Point> points = Arrays.asList(point0, point1, point2);
        Ladder ladder = new Ladder(Collections.singletonList(new Line(points)));
        int expectedPoint0 = 1;
        int expectedPoint1 = 0;
        int expectedPoint2 = 2;

        // when
        int point0Moved = ladder.startMoving(0);
        int point1Moved = ladder.startMoving(1);
        int point2Moved = ladder.startMoving(2);

        // then
        assertThat(point0Moved).isEqualTo(expectedPoint0);
        assertThat(point1Moved).isEqualTo(expectedPoint1);
        assertThat(point2Moved).isEqualTo(expectedPoint2);
    }

}