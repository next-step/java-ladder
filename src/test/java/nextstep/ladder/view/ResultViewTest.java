package nextstep.ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.LadderLineTest;
import nextstep.ladder.domain.ResultsTest;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import nextstep.ladder.domain.UsersTest;

class ResultViewTest {
    private static ResultView resultView = ResultView.getResultView();

    private List<LadderLine> lineList;
    private Ladder ladder;

    private Users resultUsers = UsersTest.USERS;
    private GameInfo gameInfo;

    @BeforeEach
    void setUp() {
        lineList = Stream.of(LadderLineTest.LINE, LadderLineTest.LINE2)
                         .collect(Collectors.toList());

        ladder = new Ladder(lineList);
        gameInfo = new GameInfo(UsersTest.USERS, ResultsTest.RESULTS);
        resultUsers.generateResultsForAllPlayers(new LadderGame(gameInfo, ladder));
    }

    @DisplayName("결과를 보고싶은 사람을 입력받을 경우 유저에 포함되는지 확인해본다. "
                 + "아닐경우 exception 발생시킨다.")
    @Test
    void validateResultUser() {
        Users users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));

        String userName = "soo";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            resultView.validateResultUser(users, userName);
        });

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
        String line = resultView.appendLine(LadderLineTest.LINE);
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
