package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Line firstLine;
    private Line secondLine;
    private Line thirdLine;
    private Players players;

    @Before
    public void setUp() {
        Point point1 = new Point(false, true);
        Point point2 = new Point(true, false);
        Point point3 = new Point(false, true);
        Point point4 = new Point(true, false);
        firstLine = new Line(Arrays.asList(point1, point2, point3, point4));

        point1 = new Point(false, false);
        point2 = new Point(false, true);
        point3 = new Point(true, false);
        point4 = new Point(false, false);
        secondLine = new Line(Arrays.asList(point1, point2, point3, point4));

        point1 = new Point(false, true);
        point2 = new Point(true, false);
        point3 = new Point(false, true);
        point4 = new Point(true, false);
        thirdLine = new Line(Arrays.asList(point1, point2, point3, point4));

        Player player1 = new Player("test1", 0);
        Player player2 = new Player("test2", 1);
        Player player3 = new Player("test3", 2);
        Player player4 = new Player("test4", 3);
        players = new Players(Arrays.asList(player1, player2, player3, player4));
    }

    @Test
    public void 사다리생성_n명_높이n() {
        int countOfPersion = 3;
        int height = 3;
        Ladder ladder = new Ladder(countOfPersion, height);
        int countOfLine = ladder.lineCount();
        assertThat(countOfLine).isEqualTo(3);
        assertThat(ladder.ladderHeight()).isEqualTo(3);
    }

    @Test
    public void 라인생성() {
        int countOfPersion = 3;
        int height = 3;
        Ladder ladder = new Ladder(countOfPersion, height);

    }

    @Test
    public void 첫번째줄사다리결과() {
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine));
        Winnings winnings = new Winnings("1, 2, 3, 4", players.size());
        Results results = ladder.playLadder(players, winnings);
        Result result = results.findResult("test1");
        System.out.println(result);
        assertThat(result.getWinning().trim()).isEqualTo("4");
    }
}
