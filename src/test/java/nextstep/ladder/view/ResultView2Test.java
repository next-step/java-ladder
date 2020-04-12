package nextstep.ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.ImprovingPoint;
import nextstep.ladder.domain.Ladder2;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.PlayLadderGame2;
import nextstep.ladder.domain.ResultsTest;
import nextstep.ladder.domain.Users;
import nextstep.ladder.domain.UsersTest;

class ResultView2Test {
    private static ResultView2 resultView = ResultView2.getResultView();
    private static PlayLadderGame2 playLadderGame = PlayLadderGame2.getPlayLadderGame();

    private LadderLine line;
    private LadderLine line2;
    private List<LadderLine> lineList;
    private Ladder2 ladder;

    private Users resultUsers;
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        List<ImprovingPoint> points = Stream.of(new ImprovingPoint(0, Direction.of(false, true)),
                                                new ImprovingPoint(1, Direction.of(true, false)),
                                                new ImprovingPoint(2, Direction.of(false, true)),
                                                new ImprovingPoint(3, Direction.of(true, false)))
                                            .collect(Collectors.toList());

        List<ImprovingPoint> points2 = Stream.of(new ImprovingPoint(0, Direction.of(false, false)),
                                                 new ImprovingPoint(1, Direction.of(false, true)),
                                                 new ImprovingPoint(2, Direction.of(true, false)),
                                                 new ImprovingPoint(3, Direction.of(false, false)))
                                             .collect(Collectors.toList());

        line = new LadderLine(points);
        line2 = new LadderLine(points2);
        lineList = Stream.of(line, line2)
                         .collect(Collectors.toList());

        ladder = new Ladder2(lineList);
        gameInfo = new GameInfo(UsersTest.USERS, ResultsTest.RESULTS);
        resultUsers = playLadderGame.generateResultsForAllPlayers(gameInfo, ladder);
    }

    @DisplayName("유저 이름을 출력한다.")
    @Test
    void appendUserNames() {
        String userNames = resultView.appendUserNames(UsersTest.USERS);
        assertThat(userNames).isEqualTo(" pobi honux crong    jk");
    }

    @DisplayName("사다리의 라인의 해당하는 값을 그린다.")
    @Test
    void appendLine() {
        String line = resultView.appendLine(this.line);
        assertThat(line).isEqualTo("     |-----|     |-----|     ");
    }

    @DisplayName("실행결과를 출력한다.")
    @Test
    void appendResults() {
        String results = resultView.appendResults(ResultsTest.RESULTS);
        assertThat(results).isEqualTo("    꽝  5000     꽝  3000");
    }

    @DisplayName("입력 받은 사다리를 그린다.")
    @Test
    void drawLadder() {
        String drawLadder = resultView.drawLadder(gameInfo, ladder);
        assertThat(drawLadder).isEqualTo(" pobi honux crong    jk\n"
                                         + "     |-----|     |-----|     \n"
                                         + "     |     |-----|     |     \n"
                                         + "    꽝  5000     꽝  3000");

    }

    @DisplayName("유저별 실행결과를 출력한다")
    @Test
    void playResult() {
        String resultByUser = resultView.playResultByUser(resultUsers, "honux");
        assertThat(resultByUser).isEqualTo("꽝");
    }

    @DisplayName("전체 실행결과를 출력한다.")
    @Test
    void playAllResult() {
        String playAllResult = resultView.playAllResult(resultUsers);
        assertThat(playAllResult).isEqualTo("pobi : 꽝\n"
                                            + "honux : 꽝\n"
                                            + "crong : 3000\n"
                                            + "jk : 5000");
    }
}
