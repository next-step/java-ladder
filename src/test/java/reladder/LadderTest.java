package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.DefaultLadderGenerator;
import reladder.domain.Ladder;
import reladder.domain.LadderLine;
import reladder.domain.Point;
import reladder.view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        // give
        Point point1 = Point.firstNext(false);
        List<Point> points1 = Arrays.asList(
                point1,
                point1.next(true),
                point1.next(true).next(false),
                point1.next(true).next(false).lastNext());
        LadderLine ladderLine1 = new LadderLine(points1);

        Point point2 = Point.firstNext(true);
        List<Point> points2 = Arrays.asList(
                point2,
                point2.next(false),
                point2.next(false).next(true),
                point2.next(false).next(true).lastNext());
        LadderLine ladderLine2 = new LadderLine(points2);

        Point point3 = Point.firstNext(false);
        List<Point> points3 = Arrays.asList(
                point3,
                point3.next(false),
                point3.next(false).next(true),
                point3.next(false).next(true).lastNext());
        LadderLine ladderLine3 = new LadderLine(points3);

        Point point4 = Point.firstNext(false);
        List<Point> points4 = Arrays.asList(
                point4,
                point4.next(true),
                point4.next(true).next(false),
                point4.next(true).next(false).lastNext());
        LadderLine ladderLine4 = new LadderLine(points4);

        ladder = new Ladder(Arrays.asList(ladderLine1, ladderLine2, ladderLine3, ladderLine4));
    }

    @Test
    @DisplayName("사다리 객체 사이즈 테스트")
    void checkSizeOfLadderTest() {
        // give
        Ladder ladder = new DefaultLadderGenerator().generate(5, 4);
        // when
        int size = ladder.getLadderLines().size();
        // then
        assertThat(size).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 이동 테스트")
    void moveLadderTest() {
        // when
        int first = ladder.move(0);
        int second = ladder.move(1);
        int third = ladder.move(2);
        int fourth = ladder.move(3);

        // then
        assertThat(first).isEqualTo(2);
        assertThat(second).isEqualTo(1);
        assertThat(third).isEqualTo(0);
        assertThat(fourth).isEqualTo(3);
    }
}
