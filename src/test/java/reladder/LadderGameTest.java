package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Ladder;
import reladder.domain.LadderLine;
import reladder.domain.MatchUp;
import reladder.domain.Point;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;
import reladder.view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LadderGame ladderGame;

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

        Ladder ladder = new Ladder(Arrays.asList(ladderLine1, ladderLine2, ladderLine3, ladderLine4));

        MatchUp matchUp = new MatchUp("a,b,c,d", "1,2,3,4");

        ladderGame = new LadderGame(ladder, matchUp);
    }

    @Test
    @DisplayName("상품 이름 가져오기")
    void getValueOfLadderGame() {
        // when
        String result = new LadderGameResult(ladderGame).getResult("a");
        // then
        assertThat(result).isEqualTo("3");
    }
}
