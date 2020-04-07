package nextstep.ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.PlayLadderGame;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

class ResultViewTest {
    private static ResultView resultView = ResultView.getResultView();
    private static PlayLadderGame playLadderGame = PlayLadderGame.getPlayLadderGame();

    private Users users;
    private Line line;
    private List<Line> lineList;
    private Ladder ladder;
    private Results results;
    private Users resultUsers;

    @BeforeEach
    void setUp() {

        List<Point> points = Stream.of(new Point(true),
                                       new Point(false),
                                       new Point(true))
                                   .collect(Collectors.toList());

        line = new Line(points);
        lineList = Stream.of(line, line)
                         .collect(Collectors.toList());

        ladder = new Ladder(lineList);

        users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));

        results = new Results(new ArrayList<>(
                Stream.of(new Result("꽝"),
                          new Result("5000"),
                          new Result("꽝"),
                          new Result("3000")
                )
                      .collect(Collectors.toList())));

        resultUsers = playLadderGame.generateResultsForAllPlayers(users, ladder, results);
    }

    @DisplayName("유저 이름을 출력한다.")
    @Test
    void appendUserNames() {
        String userNames = resultView.appendUserNames(users);
        assertThat(userNames).isEqualTo(" pobi honux crong    jk");
    }

    @DisplayName("사다리의 라인의 해당하는 값을 그린다.")
    @Test
    void appendLine() {
        String line = resultView.appendLine(this.line);
        assertThat(line).isEqualTo("     |-----|     |-----|");
    }

    @DisplayName("실행결과를 출력한다.")
    @Test
    void appendResults() {
        String results = resultView.appendResults(this.results);
        assertThat(results).isEqualTo("    꽝  5000     꽝  3000");
    }

    @DisplayName("입력 받은 사다리를 그린다.")
    @Test
    void drawLadder() {
        String drawLadder = resultView.drawLadder(users, ladder, results);
        assertThat(drawLadder).isEqualTo(" pobi honux crong    jk\n"
                                         + "     |-----|     |-----|\n"
                                         + "     |-----|     |-----|\n"
                                         + "    꽝  5000     꽝  3000");

    }

    @DisplayName("유저별 실행결과를 출력한다")
    @Test
    void playResult() {
        String resultByUser = resultView.playResultByUser(resultUsers, "honux");
        assertThat(resultByUser).isEqualTo("5000");
    }

    @Test
    void playAllResult() {
        String playAllResult = resultView.playAllResult(resultUsers);
        assertThat(playAllResult).isEqualTo("pobi : 꽝\n"
                                            + "honux : 5000\n"
                                            + "crong : 꽝\n"
                                            + "jk : 3000");
    }
}
